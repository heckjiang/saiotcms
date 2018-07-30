package com.saiot.cms.core.repository;

import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.NodeBuffer;

/**
 * NodeBufferDao
 * 
 * @author jiangjun
 * 
 */
public interface NodeBufferDao extends Repository<NodeBuffer, Integer> {
	public NodeBuffer findOne(Integer id);

	public NodeBuffer save(NodeBuffer bean);
}
