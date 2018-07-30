package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.MemberGroup;
import com.saiot.cms.core.domain.Node;

public interface NodeMemberGroupService {
	public void update(MemberGroup group, Integer[] viewNodeIds,
			Integer[] contriNodeIds, Integer[] commentNodeIds, Integer siteId);

	public void update(Node node, Integer[] viewGroupIds,
			Integer[] contriGroupIds, Integer[] commentGroupIds);
}
