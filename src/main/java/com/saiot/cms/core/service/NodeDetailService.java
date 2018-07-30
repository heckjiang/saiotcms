package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Node;
import com.saiot.cms.core.domain.NodeDetail;

/**
 * NodeDetailService
 * 
 * @author jiangjun
 * 
 */
public interface NodeDetailService {
	public void save(NodeDetail detail, Node node);

	public NodeDetail update(NodeDetail detail, Node node);
}
