package com.saiot.cms.ext.web.fore;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.support.Context;
import com.saiot.cms.core.support.ForeContext;
import com.saiot.cms.core.support.SiteResolver;

/**
 * SiteMapController
 * 
 * @author yangxing
 * 
 */
@Controller
public class SiteMapController {
	public static final String TEMPLATE = "sys_sitemap.html";

	@RequestMapping("/sitemap")
	public String index(HttpServletRequest request,
			HttpServletResponse response, org.springframework.ui.Model modelMap) {
		return index(null, request, response, modelMap);
	}

	@RequestMapping(Constants.SITE_PREFIX_PATH + "/sitemap")
	public String index(@PathVariable String siteNumber,
			HttpServletRequest request, HttpServletResponse response,
			org.springframework.ui.Model modelMap) {
		siteResolver.resolveSite(siteNumber);
		Site site = Context.getCurrentSite();
		Map<String, Object> data = modelMap.asMap();
		ForeContext.setData(data, request);
		return site.getTemplate(TEMPLATE);
	}

	@Autowired
	private SiteResolver siteResolver;
}
