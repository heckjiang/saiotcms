package com.saiot.cms.core.service;

import java.util.List;

import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.domain.UserRole;

public interface UserRoleService {
	public List<UserRole> update(User user, Integer[] roleIds, Integer siteId);
}
