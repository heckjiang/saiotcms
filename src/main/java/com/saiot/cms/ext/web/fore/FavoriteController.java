package com.saiot.cms.ext.web.fore;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.support.Context;
import com.saiot.cms.core.support.ForeContext;
import com.saiot.cms.core.support.Response;
import com.saiot.cms.ext.domain.Favorite;
import com.saiot.cms.ext.service.FavoriteService;

/**
 * FavoriteController 收藏Controller
 * 
 * @author jiangjun
 * 
 */
@Controller
public class FavoriteController {
	public static final String TEMPLATE = "sys_member_favorite.html";

	@RequestMapping(path = { "/my/favorite", Constants.SITE_PREFIX_PATH + "/my/favorite" })
	public String index(Integer page, HttpServletRequest request, HttpServletResponse response,
			org.springframework.ui.Model modelMap) {
		Site site = Context.getCurrentSite();
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		ForeContext.setPage(data, page);
		return site.getTemplate(TEMPLATE);
	}

	@RequestMapping(path = { "/my/favorite/delete", Constants.SITE_PREFIX_PATH + "/my/favorite/delete" })
	public String delete(Integer[] ids, HttpServletRequest request, HttpServletResponse response,
			org.springframework.ui.Model modelMap) {
		Response resp = new Response(request, response, modelMap);
		if (ArrayUtils.isEmpty(ids)) {
			return resp.badRequest();
		}
		User user = Context.getCurrentUser();
		for (Integer id : ids) {
			Favorite bean = service.get(id);
			// 不是自己收藏的，不能删除
			if (!bean.getUser().getId().equals(user.getId())) {
				return resp.post(501, "error.forbiddenData");
			}
			service.delete(id);
		}
		return resp.post();
	}

	@Autowired
	private FavoriteService service;
}
