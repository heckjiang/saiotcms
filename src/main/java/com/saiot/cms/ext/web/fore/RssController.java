package com.saiot.cms.ext.web.fore;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saiot.cms.common.web.Servlets;
import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.support.Context;
import com.saiot.cms.core.support.ForeContext;
import com.saiot.cms.core.support.SiteResolver;

/**
 * RssSubscription
 * 
 * @author yangxing
 * 
 */
@Controller
public class RssController {
	public static final String RSS_CENTER_TEMPLATE = "sys_rss_center.html";
	public static final String RSS_TEMPLATE = "sys_rss.html";

	@RequestMapping("/rss_center")
	public String center(HttpServletRequest request,
			org.springframework.ui.Model modelMap) {
		return center(null, request, modelMap);
	}

	@RequestMapping(Constants.SITE_PREFIX_PATH + "/rss_center")
	public String center(@PathVariable String siteNumber,
			HttpServletRequest request, org.springframework.ui.Model modelMap) {
		siteResolver.resolveSite(siteNumber);
		Site site = Context.getCurrentSite();
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		return site.getTemplate(RSS_CENTER_TEMPLATE);
	}

	@RequestMapping("/rss")
	public String list(Integer nodeId, HttpServletRequest request,
			HttpServletResponse response, org.springframework.ui.Model modelMap) {
		return list(null, nodeId, request, response, modelMap);
	}

	@RequestMapping(Constants.SITE_PREFIX_PATH + "/rss")
	public String list(@PathVariable String siteNumber, Integer nodeId,
			HttpServletRequest request, HttpServletResponse response,
			org.springframework.ui.Model modelMap) {
		siteResolver.resolveSite(siteNumber);
		response.setContentType("text/xml;charset=utf-8");
		Servlets.setNoCacheHeader(response);
		Site site = Context.getCurrentSite();
		modelMap.addAttribute("nodeId", nodeId);
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		return site.getTemplate(RSS_TEMPLATE);
	}

	@Autowired
	private SiteResolver siteResolver;
}
