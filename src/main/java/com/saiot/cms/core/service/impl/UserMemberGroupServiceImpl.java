package com.saiot.cms.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.MemberGroup;
import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.domain.UserMemberGroup;
import com.saiot.cms.core.domain.UserMemberGroup.UserMemberGroupId;
import com.saiot.cms.core.listener.MemberGroupDeleteListener;
import com.saiot.cms.core.repository.UserMemberGroupDao;
import com.saiot.cms.core.service.MemberGroupService;
import com.saiot.cms.core.service.UserMemberGroupService;

@Service
@Transactional(readOnly = true)
public class UserMemberGroupServiceImpl implements UserMemberGroupService, MemberGroupDeleteListener {

	private UserMemberGroup findOrCreate(User user, MemberGroup group) {
		UserMemberGroup bean = dao.findOne(new UserMemberGroupId(user.getId(), group.getId()));
		if (bean == null) {
			bean = new UserMemberGroup(user, group);
		}
		return bean;
	}

	@Transactional
	public List<UserMemberGroup> update(User user, Integer[] groupIds, Integer groupId) {
		// 主会员组为null，不更新。
		if (groupId == null) {
			return user.getUserGroups();
		}
		if (groupIds == null) {
			groupIds = new Integer[0];
		} else {
			groupIds = ArrayUtils.removeElement(groupIds, groupId);
		}
		List<UserMemberGroup> userGroups = user.getUserGroups();
		userGroups.clear();
		userGroups.add(findOrCreate(user, groupService.get(groupId)));
		for (Integer id : groupIds) {
			userGroups.add(findOrCreate(user, groupService.get(id)));
		}
		return userGroups;
	}

	public void preMemberGroupDelete(Integer[] ids) {
		for (Integer id : ids) {
			MemberGroup group = groupService.get(id);
			for (User user : dao.findByUserGroupsGroupId(id)) {
				UserMemberGroup userGroup = new UserMemberGroup(user, group);
				user.getUserGroups().remove(userGroup);
				dao.delete(userGroup);
			}
		}
	}

	private MemberGroupService groupService;

	@Autowired
	public void setMemberGroupService(MemberGroupService groupService) {
		this.groupService = groupService;
	}

	private UserMemberGroupDao dao;

	@Autowired
	public void setDao(UserMemberGroupDao dao) {
		this.dao = dao;
	}
}
