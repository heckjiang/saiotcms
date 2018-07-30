package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.User;

public interface UserOrgService {
	public void update(User user, Integer[] orgIds, Integer orgId, Integer topOrgId);
}
