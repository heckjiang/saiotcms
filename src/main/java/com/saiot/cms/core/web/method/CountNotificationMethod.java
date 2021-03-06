package com.saiot.cms.core.web.method;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.saiot.cms.common.freemarker.Freemarkers;
import com.saiot.cms.core.service.NotificationService;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * 通过用户ID获取通知数量
 * 
 * @author jiangjun
 * 
 */
public class CountNotificationMethod implements TemplateMethodModelEx {
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() < 1) {
			throw new TemplateModelException("Wrong arguments");
		}
		TemplateModel arg0 = (TemplateModel) args.get(0);
		Integer receiverId = Freemarkers.getIntegerRequired(arg0, "arg0");
		int count = service.countByReceiverId(receiverId);
		return count;
	}

	@Autowired
	private NotificationService service;
}
