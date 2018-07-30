package com.saiot.cms.core.web.back;

import static com.saiot.cms.core.constant.Constants.DELETE_SUCCESS;
import static com.saiot.cms.core.constant.Constants.EDIT;
import static com.saiot.cms.core.constant.Constants.MESSAGE;
import static com.saiot.cms.core.constant.Constants.OPRT;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.common.web.Servlets;
import com.saiot.cms.core.domain.OperationLog;
import com.saiot.cms.core.service.OperationLogService;
import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.support.Context;

@Controller
@RequestMapping("/core/login_log")
public class LoginLogController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginLogController.class);

	@RequiresPermissions("core:login_log:list")
	@RequestMapping("list.do")
	public String list(
			@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable,
			HttpServletRequest request, org.springframework.ui.Model modelMap) {
		Integer siteId = Context.getCurrentSiteId();
		Map<String, String[]> params = Servlets.getParamValuesMap(request,
				Constants.SEARCH_PREFIX);
		Page<OperationLog> pagedList = service
				.findAll(siteId, params, pageable);
		modelMap.addAttribute("pagedList", pagedList);
		return "core/login_log/login_log_list";
	}

	@RequiresPermissions("core:login_log:view")
	@RequestMapping("view.do")
	public String view(
			Integer id,
			Integer position,
			@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable,
			HttpServletRequest request, org.springframework.ui.Model modelMap) {
		Integer siteId = Context.getCurrentSiteId();
		OperationLog bean = service.get(id);
		Map<String, String[]> params = Servlets.getParamValuesMap(request,
				Constants.SEARCH_PREFIX);
		RowSide<OperationLog> side = service.findSide(siteId, params, bean,
				position, pageable.getSort());
		modelMap.addAttribute("bean", bean);
		modelMap.addAttribute("side", side);
		modelMap.addAttribute("position", position);
		modelMap.addAttribute(OPRT, EDIT);
		return "core/login_log/login_log_form";
	}

	@RequiresPermissions("core:login_log:delete")
	@RequestMapping("delete.do")
	public String delete(Integer[] ids, RedirectAttributes ra) {
		List<OperationLog> beans = service.delete(ids);
		for (OperationLog bean : beans) {
			logger.info("delete OperationLog, name={}.", bean.getName());
		}
		ra.addFlashAttribute(MESSAGE, DELETE_SUCCESS);
		return "redirect:list.do";
	}

	@ModelAttribute("bean")
	public OperationLog preloadBean(@RequestParam(required = false) Integer oid) {
		return oid != null ? service.get(oid) : null;
	}

	@Autowired
	private OperationLogService service;
}
