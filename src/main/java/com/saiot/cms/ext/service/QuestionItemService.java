package com.saiot.cms.ext.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.ext.domain.Question;
import com.saiot.cms.ext.domain.QuestionItem;

public interface QuestionItemService {
	public RowSide<QuestionItem> findSide(Map<String, String[]> params,
			QuestionItem bean, Integer position, Sort sort);

	public QuestionItem get(Integer id);

	public List<QuestionItem> save(String[] title, Boolean[] essay,
			Question question);

	public List<QuestionItem> update(Integer[] id, String[] title,
			Boolean[] essay, Question question);

	public QuestionItem update(QuestionItem bean, Integer[] optionId,
			String[] optionTitle);

	public QuestionItem delete(QuestionItem entity);
}
