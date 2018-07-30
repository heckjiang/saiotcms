package com.saiot.cms.ext.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.QuestionItemRec;
import com.saiot.cms.ext.repository.plus.QuestionItemRecDaoPlus;

public interface QuestionItemRecDao extends Repository<QuestionItemRec, Integer>, QuestionItemRecDaoPlus {
	public Page<QuestionItemRec> findAll(Specification<QuestionItemRec> spec, Pageable pageable);

	public List<QuestionItemRec> findAll(Specification<QuestionItemRec> spec, Limitable limitable);

	public QuestionItemRec findOne(Integer id);

	public QuestionItemRec save(QuestionItemRec bean);

	public void delete(QuestionItemRec bean);
	
	// --------------------
	
}
