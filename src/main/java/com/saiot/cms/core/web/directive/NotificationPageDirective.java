package com.saiot.cms.core.web.directive;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * InboxPageDirective
 * 
 * @author jiangjun
 * 
 */
public class NotificationPageDirective extends AbstractNotificationListPageDirective implements TemplateDirectiveModel {
	@SuppressWarnings("rawtypes")
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		super.doExecute(env, params, loopVars, body, true);
	}
}
