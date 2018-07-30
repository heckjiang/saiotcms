package com.saiot.cms.ext.service;

import java.util.List;

import com.saiot.cms.ext.domain.QuestionItem;
import com.saiot.cms.ext.domain.QuestionOption;

public interface QuestionOptionService {
	public QuestionOption get(Integer id);

	public List<QuestionOption> save(String[] title, QuestionItem item);

	public List<QuestionOption> update(Integer[] id, String[] title,
			QuestionItem item);

}
