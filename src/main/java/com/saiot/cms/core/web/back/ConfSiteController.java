package com.saiot.cms.core.web.back;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saiot.cms.common.web.PathResolver;
import com.saiot.cms.common.web.Servlets;
import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.domain.Model;
import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.domain.SiteWatermark;
import com.saiot.cms.core.domain.SiteWeixin;
import com.saiot.cms.core.service.ModelService;
import com.saiot.cms.core.service.OperationLogService;
import com.saiot.cms.core.service.SiteService;
import com.saiot.cms.core.support.Context;

import javax.servlet.http.HttpServletRequest;

import static com.saiot.cms.core.constant.Constants.MESSAGE;
import static com.saiot.cms.core.constant.Constants.SAVE_SUCCESS;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ConfSiteController
 *
 * @author jiangjun
 */
@Controller
@RequestMapping("/core/conf_site")
public class ConfSiteController {
    public static final String TYPE = "type";

    @RequiresPermissions("core:conf_site:base_edit")
    @RequestMapping("base_edit.do")
    public String baseEdit(HttpServletRequest request,
                           org.springframework.ui.Model modelMap) {
        Site site = Context.getCurrentSite();
        String templateBase = site.getSiteBase("");
        File templateBaseFile = new File(pathResolver.getPath(templateBase,
                Constants.TEMPLATE_STORE_PATH));
        File[] themeFiles = templateBaseFile.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        List<String> themeList = new ArrayList<String>();
        if (ArrayUtils.isNotEmpty(themeFiles)) {
            for (File themeFile : themeFiles) {
                themeList.add(themeFile.getName());
            }
        }
        modelMap.addAttribute("site", site);
        modelMap.addAttribute("themeList", themeList);
        modelMap.addAttribute(TYPE, "base");
        return "core/conf_site/conf_site_base";
    }

    @RequiresPermissions("core:conf_site:base_update")
    @RequestMapping("base_update.do")
    public String baseUpdate(@ModelAttribute("bean") Site bean,
                             HttpServletRequest request, RedirectAttributes ra) {
        service.update(bean);
        logService.operation("opr.confSite.baseEdit", bean.getName(), null,
                bean.getId(), request);
        ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
        return "redirect:base_edit.do";
    }

    @RequiresPermissions("core:conf_site:custom_edit")
    @RequestMapping("custom_edit.do")
    public String customEdit(HttpServletRequest request,
                             org.springframework.ui.Model modelMap) {
        Site site = Context.getCurrentSite();
        Model model = modelService.findDefault(site.getId(), Site.MODEL_TYPE);
        modelMap.addAttribute("site", site);
        modelMap.addAttribute("model", model);
        modelMap.addAttribute(TYPE, "custom");
        return "core/conf_site/conf_site_custom";
    }

    @RequiresPermissions("core:conf_site:custom_update")
    @RequestMapping("custom_update.do")
    public String customUpdate(@ModelAttribute("bean") Site bean, HttpServletRequest request, RedirectAttributes ra) {
        Map<String, String> map = Servlets.getParamMap(request, "customs_");
        Map<String, String> clobMap = Servlets.getParamMap(request,
                "clobs_");
        service.updateCustoms(bean, map, clobMap);
        logService.operation("opr.confSite.customEdit", bean.getName(), null,
                bean.getId(), request);
        ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
        return "redirect:custom_edit.do";
    }

    @RequiresPermissions("core:conf_site:watermark_edit")
    @RequestMapping("watermark_edit.do")
    public String watermarkEdit(HttpServletRequest request, org.springframework.ui.Model modelMap) {
        Site site = Context.getCurrentSite();
        modelMap.addAttribute("site", site);
        modelMap.addAttribute(TYPE, "watermark");
        return "core/conf_site/conf_site_watermark";
    }

    @RequiresPermissions("core:conf_site:watermark_update")
    @RequestMapping("watermark_update.do")
    public String watermarkUpdate(SiteWatermark bean, HttpServletRequest request, RedirectAttributes ra) {
        Site site = Context.getCurrentSite();
        service.updateConf(site, bean);
        logService.operation("opr.confSite.watermarkEdit", site.getName(), null, site.getId(), request);
        ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
        return "redirect:watermark_edit.do";
    }

    @RequiresPermissions("core:conf_site:weixin_edit")
    @RequestMapping("weixin_edit.do")
    public String weixinEdit(HttpServletRequest request, org.springframework.ui.Model modelMap) {
        Site site = Context.getCurrentSite();
        modelMap.addAttribute("site", site);
        modelMap.addAttribute(TYPE, "weixin");
        return "core/conf_site/conf_site_weixin";
    }

    @RequiresPermissions("core:conf_site:weixin_update")
    @RequestMapping("weixin_update.do")
    public String weixinUpdate(SiteWeixin bean, HttpServletRequest request, RedirectAttributes ra) {
        Site site = Context.getCurrentSite();
        service.updateConf(site, bean);
        logService.operation("opr.confSite.weixinEdit", site.getName(), null, site.getId(), request);
        ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
        return "redirect:weixin_edit.do";
    }

    @ModelAttribute("bean")
    public Site preloadBean(HttpServletRequest request) {
        return Context.getCurrentSite();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("version");
    }

    @Autowired
    private OperationLogService logService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private PathResolver pathResolver;
    @Autowired
    private SiteService service;
}
