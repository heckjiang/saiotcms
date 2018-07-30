package com.saiot.cms.core.repository;

import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.NodeDetail;

/**
 * NodeDetailDao
 * 
 * @author jiangjun
 * 
 */
public interface NodeDetailDao extends Repository<NodeDetail, Integer> {
	public NodeDetail findOne(Integer id);

	public NodeDetail save(NodeDetail bean);
}
