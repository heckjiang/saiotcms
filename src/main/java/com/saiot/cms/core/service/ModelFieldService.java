package com.saiot.cms.core.service;

import java.util.List;
import java.util.Map;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.Model;
import com.saiot.cms.core.domain.ModelField;

/**
 * ModelFieldService
 * 
 * @author jiangjun
 * 
 */
public interface ModelFieldService {
	public List<ModelField> findList(Integer modelId);

	public RowSide<ModelField> findSide(Integer modelId, ModelField bean,
			Integer position);

	public ModelField get(Integer id);

	public ModelField[] batchSave(Integer modelId, String[] name,
			String[] label, Boolean[] dblColumn, String[] property,
			String[] custom);

	public ModelField save(ModelField bean, Integer modelId,
			Map<String, String> customs, Boolean clob);

	public ModelField copy(ModelField bean, Model model);

	public ModelField clone(ModelField field, Model model);

	public ModelField[] batchUpdate(Integer[] id, String[] name,
			String[] label, Boolean[] dblColumn);

	public ModelField update(ModelField bean, Map<String, String> customs,
			Boolean clob);

	public ModelField[] disable(Integer[] ids);

	public ModelField[] enable(Integer[] ids);

	public ModelField delete(Integer id);

	public ModelField[] delete(Integer[] ids);
}
