package com.saiot.cms.ext.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.QuestionOption;
import com.saiot.cms.ext.repository.plus.QuestionOptionDaoPlus;

public interface QuestionOptionDao extends Repository<QuestionOption, Integer>, QuestionOptionDaoPlus {
	public Page<QuestionOption> findAll(Specification<QuestionOption> spec, Pageable pageable);

	public List<QuestionOption> findAll(Specification<QuestionOption> spec, Limitable limitable);

	public QuestionOption findOne(Integer id);

	public QuestionOption save(QuestionOption bean);

	public void delete(QuestionOption bean);
	
	// --------------------
	
}
