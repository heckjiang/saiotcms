package com.saiot.cms.core.repository;

import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.Global;

/**
 * GlobalDao
 * 
 * @author jiangjun
 * 
 */
public interface GlobalDao extends Repository<Global, Integer> {
	public Global findOne(Integer id);

	public Global save(Global entity);
}