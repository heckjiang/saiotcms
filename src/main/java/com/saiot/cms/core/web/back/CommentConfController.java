package com.saiot.cms.core.web.back;

import static com.saiot.cms.core.constant.Constants.MESSAGE;
import static com.saiot.cms.core.constant.Constants.SAVE_SUCCESS;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saiot.cms.core.domain.Site;
import com.saiot.cms.core.domain.SiteComment;
import com.saiot.cms.core.service.OperationLogService;
import com.saiot.cms.core.service.SiteService;
import com.saiot.cms.core.support.Context;

/**
 * CommentConfController
 * 
 * @author jiangjun
 * 
 */
@Controller
@RequestMapping("/core/comment_conf")
public class CommentConfController {
	private static final Logger logger = LoggerFactory
			.getLogger(CommentConfController.class);

	@RequiresPermissions("core:comment_conf:edit")
	@RequestMapping("edit.do")
	public String edit(HttpServletRequest request,
			org.springframework.ui.Model modelMap) {
		Site site = Context.getCurrentSite();
		SiteComment siteComment = new SiteComment(site.getCustoms());
		modelMap.addAttribute("bean", siteComment);
		return "core/comment_conf/comment_conf";
	}

	@RequiresPermissions("core:comment_conf:update")
	@RequestMapping("update.do")
	public String update(SiteComment bean, HttpServletRequest request,
			RedirectAttributes ra) {
		Site site = Context.getCurrentSite();
		siteService.updateConf(site, bean);
		logService.operation("opr.commentConf.edit", site.getName(),
				null, site.getId(), request);
		logger.info("update Comment config.");
		ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
		return "redirect:edit.do";
	}

	@Autowired
	private OperationLogService logService;
	@Autowired
	private SiteService siteService;
}
