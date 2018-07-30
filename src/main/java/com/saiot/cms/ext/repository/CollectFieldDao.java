package com.saiot.cms.ext.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.CollectField;
import com.saiot.cms.ext.repository.plus.CollectFieldDaoPlus;

public interface CollectFieldDao extends Repository<CollectField, Integer>, CollectFieldDaoPlus {
	public List<CollectField> findAll(Specification<CollectField> spec, Sort sort);

	public List<CollectField> findAll(Specification<CollectField> spec, Limitable limit);

	public CollectField findOne(Integer id);

	public CollectField save(CollectField bean);

	public void delete(CollectField bean);

	// --------------------

}
