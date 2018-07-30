package com.saiot.cms.core.service;

import java.util.List;

import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.domain.UserMemberGroup;

public interface UserMemberGroupService {
	public List<UserMemberGroup> update(User user, Integer[] groupIds, Integer groupId);
}
