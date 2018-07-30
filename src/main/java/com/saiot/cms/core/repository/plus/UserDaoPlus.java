package com.saiot.cms.core.repository.plus;

import java.util.List;

import com.saiot.cms.core.domain.User;

/**
 * UserDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface UserDaoPlus {
	public List<User> findByUsername(String[] usernames);
}
