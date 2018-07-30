package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Node;
import com.saiot.cms.core.domain.NodeBuffer;

/**
 * NodeBufferService
 * 
 * @author jiangjun
 * 
 */
public interface NodeBufferService {
	public NodeBuffer get(Integer id);

	public NodeBuffer save(NodeBuffer bean, Node node);

	public int updateViews(Integer id);
}
