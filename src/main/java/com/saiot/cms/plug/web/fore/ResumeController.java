package com.saiot.cms.plug.web.fore;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.support.Context;
import com.saiot.cms.core.support.ForeContext;
import com.saiot.cms.core.support.Response;
import com.saiot.cms.core.support.SiteResolver;
import com.saiot.cms.plug.domain.Resume;
import com.saiot.cms.plug.service.ResumeService;

/**
 * ResumeController
 * 
 * @author jiangjun
 * 
 */
@Controller
public class ResumeController {
	public static final String TEMPLATE = "plug_resume.html";

	@RequestMapping(value = "/resume")
	public String form(Integer page, HttpServletRequest request,
			org.springframework.ui.Model modelMap) {
		return form(null, page, request, modelMap);
	}

	@RequestMapping(value = Constants.SITE_PREFIX_PATH + "/resume")
	public String form(@PathVariable String siteNumber, Integer page,
			HttpServletRequest request, org.springframework.ui.Model modelMap) {
		siteResolver.resolveSite(siteNumber);
		Site site = Context.getCurrentSite();
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		ForeContext.setPage(data, page);
		return site.getTemplate(TEMPLATE);
	}

	@RequestMapping(value = "/resume", method = RequestMethod.POST)
	public String submit(@Valid Resume bean, HttpServletRequest request,
			HttpServletResponse response, org.springframework.ui.Model modelMap) {
		return submit(null, bean, request, response, modelMap);
	}

	@RequestMapping(value = Constants.SITE_PREFIX_PATH + "/resume", method = RequestMethod.POST)
	public String submit(@PathVariable String siteNumber, @Valid Resume bean,
			HttpServletRequest request, HttpServletResponse response,
			org.springframework.ui.Model modelMap) {
		siteResolver.resolveSite(siteNumber);
		Response resp = new Response(request, response, modelMap);
		Site site = Context.getCurrentSite();
		service.save(bean, site.getId());
		return resp.post();
	}

	@Autowired
	private SiteResolver siteResolver;
	@Autowired
	private ResumeService service;
}
