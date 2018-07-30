package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Node;
import com.saiot.cms.core.domain.Role;

public interface NodeRoleService {
	public void update(Role role, Integer[] infoPermIds, Integer[] nodePermIds);

	public void update(Node node, Integer[] infoPermIds, Integer[] nodePermIds);
}
