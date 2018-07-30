package com.saiot.cms.core.repository;

import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.InfoBuffer;

/**
 * InfoBufferDao
 * 
 * @author jiangjun
 * 
 */
public interface InfoBufferDao extends Repository<InfoBuffer, Integer> {
	public InfoBuffer findOne(Integer id);

	public InfoBuffer save(InfoBuffer bean);
}
