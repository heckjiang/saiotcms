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
import com.saiot.cms.core.domain.Message;
import com.saiot.cms.core.service.MessageService;
import com.saiot.cms.core.support.ForeContext;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * AbstractMessageContactListPageDirective
 * 
 * @author jiangjun
 * 
 */
public abstract class AbstractMessageContactListPageDirective {

	public static final String USER_ID = "userId";
	public static final String CONTACT_ID = "contactId";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doExecute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body,
			boolean isPage) throws TemplateException, IOException {
		if (loopVars.length < 1) {
			throw new TemplateModelException("Loop variable is required.");
		}
		if (body == null) {
			throw new RuntimeException("missing body");
		}

		Integer userId = Freemarkers.getInteger(params, USER_ID);
		Integer contactId = Freemarkers.getInteger(params, CONTACT_ID);

		Sort defSort = new Sort(Direction.DESC, "sendTime");
		if (isPage) {
			Pageable pageable = Freemarkers.getPageable(params, env, defSort);
			Page<Message> pagedList = service.findByContactId(userId, contactId, pageable);
			ForeContext.setTotalPages(pagedList.getTotalPages());
			loopVars[0] = env.getObjectWrapper().wrap(pagedList);
		} else {
			Limitable limitable = Freemarkers.getLimitable(params, defSort);
			List<Message> list = service.findByContactId(userId, contactId, limitable);
			loopVars[0] = env.getObjectWrapper().wrap(list);
		}

		body.render(env.getOut());
	}

	@Autowired
	private MessageService service;
}
