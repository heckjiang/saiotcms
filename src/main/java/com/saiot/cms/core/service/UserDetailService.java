package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.domain.UserDetail;

public interface UserDetailService {
	public UserDetail get(Integer id);

	public UserDetail save(UserDetail detail, User user, String ip);

	public UserDetail update(UserDetail detail);
}
