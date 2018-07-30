package com.saiot.cms.core.web.method;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.saiot.cms.common.freemarker.Freemarkers;
import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.service.InfoQueryService;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * GetInfoMethod
 * 
 * @author jiangjun
 * 
 */
public class GetInfoMethod implements TemplateMethodModelEx {
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() < 1) {
			throw new TemplateModelException("Wrong arguments");
		}
		TemplateModel arg0 = (TemplateModel) args.get(0);
		Integer id = Freemarkers.getIntegerRequired(arg0, "arg0");
		Info info = query.get(id);
		return info;
	}

	@Autowired
	private InfoQueryService query;
}
