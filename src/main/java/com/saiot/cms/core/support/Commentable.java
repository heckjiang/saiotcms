package com.saiot.cms.core.support;

import java.util.Collection;

import com.saiot.cms.core.domain.MemberGroup;
import com.saiot.cms.core.domain.User;

/**
 * Commentable
 * 
 * @author jiangjun
 * 
 */
public interface Commentable {
	/**
	 * 增加评论数量
	 * 
	 * @param comments
	 */
	public void addComments(int comments);

	/**
	 * 获取评论状态
	 * 
	 * @param groups
	 * @return
	 */
	public int getCommentStatus(User user, Collection<MemberGroup> groups);
}
