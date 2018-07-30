package com.saiot.cms.core.web.fore;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.domain.SpecialCategory;
import com.saiot.cms.core.service.SpecialCategoryService;
import com.saiot.cms.core.support.Context;
import com.saiot.cms.core.support.ForeContext;
import com.saiot.cms.core.support.Response;
import com.saiot.cms.core.support.SiteResolver;

/**
 * SpecialsController
 * 
 * @author jiangjun
 * 
 */
@Controller
public class SpecialCategoryController {
	public static final String TEMPLATE_LIST = "sys_special_category_list.html";
	public static final String TEMPLATE = "sys_special_category.html";

	@RequestMapping("/special_category")
	public String index(Integer page, HttpServletRequest request,
			org.springframework.ui.Model modelMap) {
		return index(null, page, request, modelMap);
	}

	@RequestMapping(Constants.SITE_PREFIX_PATH + "/special_category")
	public String index(@PathVariable String siteNumber, Integer page,
			HttpServletRequest request, org.springframework.ui.Model modelMap) {
		siteResolver.resolveSite(siteNumber);
		Site site = Context.getCurrentSite();
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		ForeContext.setPage(data, page);
		return site.getTemplate(TEMPLATE_LIST);
	}

	@RequestMapping("/special_category/{id:[0-9]+}")
	public String show(@PathVariable Integer id, Integer page,
			HttpServletRequest request, HttpServletResponse response,
			org.springframework.ui.Model modelMap) {
		return show(null, id, page, request, response, modelMap);
	}

	@RequestMapping(Constants.SITE_PREFIX_PATH
			+ "/special_category/{id:[0-9]+}")
	public String show(@PathVariable String siteNumber,
			@PathVariable Integer id, Integer page, HttpServletRequest request,
			HttpServletResponse response, org.springframework.ui.Model modelMap) {
		SpecialCategory category = service.get(id);
		siteResolver.resolveSite(siteNumber, category);
		Site site = Context.getCurrentSite();

		Response resp = new Response(request, response, modelMap);
		if (category == null) {
			return resp.badRequest("SpecialCategory not found: " + id);
		}
		modelMap.addAttribute("category", category);
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		ForeContext.setPage(data, page);
		return site.getTemplate(TEMPLATE);
	}

	@Autowired
	private SiteResolver siteResolver;
	@Autowired
	private SpecialCategoryService service;
}
