package com.saiot.cms.core.web.directive;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.saiot.cms.common.freemarker.Freemarkers;
import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.service.InfoQueryService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * InfoDirective
 * 
 * @author jiangjun
 * 
 */
public class InfoDirective implements TemplateDirectiveModel {
	public static final String ID = "id";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		if (loopVars.length < 1) {
			throw new TemplateModelException("Loop variable is required.");
		}
		if (body == null) {
			throw new RuntimeException("missing body");
		}
		Integer id = Freemarkers.getInteger(params, ID);
		Info info = query.get(id);
		loopVars[0] = env.getObjectWrapper().wrap(info);
		body.render(env.getOut());
	}

	@Autowired
	private InfoQueryService query;
}
