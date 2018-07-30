package com.saiot.cms.core.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.ModelField;

/**
 * ModelFieldDao
 * 
 * @author jiangjun
 * 
 */
public interface ModelFieldDao extends Repository<ModelField, Integer> {
	public List<ModelField> findAll(Specification<ModelField> spec, Sort sort);

	public List<ModelField> findAll(Specification<ModelField> spec,
			Limitable limit);

	public ModelField findOne(Integer id);

	public ModelField save(ModelField bean);

	public void delete(ModelField bean);

	// --------------------

}
