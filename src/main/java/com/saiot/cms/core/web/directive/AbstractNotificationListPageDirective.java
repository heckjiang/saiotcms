package com.saiot.cms.core.web.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.saiot.cms.common.freemarker.Freemarkers;
import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Notification;
import com.saiot.cms.core.service.NotificationService;
import com.saiot.cms.core.support.ForeContext;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * AbstractNotificationListPageDirective
 * 
 * @author jiangjun
 * 
 */
public abstract class AbstractNotificationListPageDirective {

	public static final String RECEIVER_ID = "receiverId";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doExecute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body,
			boolean isPage) throws TemplateException, IOException {
		if (loopVars.length < 1) {
			throw new TemplateModelException("Loop variable is required.");
		}
		if (body == null) {
			throw new RuntimeException("missing body");
		}

		Integer receiverId = Freemarkers.getInteger(params, RECEIVER_ID);

		Sort defSort = new Sort(Direction.DESC, "sendTime");
		if (isPage) {
			Pageable pageable = Freemarkers.getPageable(params, env, defSort);
			Page<Notification> pagedList = service.findAll(receiverId, null, pageable);
			ForeContext.setTotalPages(pagedList.getTotalPages());
			loopVars[0] = env.getObjectWrapper().wrap(pagedList);
		} else {
			Limitable limitable = Freemarkers.getLimitable(params, defSort);
			List<Notification> list = service.findAll(receiverId, null, limitable);
			loopVars[0] = env.getObjectWrapper().wrap(list);
		}

		body.render(env.getOut());
	}

	@Autowired
	private NotificationService service;
}
