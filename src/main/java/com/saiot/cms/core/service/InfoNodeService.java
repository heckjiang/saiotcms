package com.saiot.cms.core.service;

import java.util.Collection;
import java.util.List;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.InfoNode;

public interface InfoNodeService {
	public List<InfoNode> update(Info info, Integer[] nodeIds, Integer nodeId);

	public int moveByNodeId(Collection<Integer> nodeIds, Integer nodeId);

	public void deleteByNodeId(Integer nodeId);
}
