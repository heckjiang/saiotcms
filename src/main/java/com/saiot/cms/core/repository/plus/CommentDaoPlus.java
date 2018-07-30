package com.saiot.cms.core.repository.plus;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Comment;

/**
 * CommentDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface CommentDaoPlus {
	public List<Comment> findList(String ftype, Integer fid, Integer creatorId,
			Integer[] status, Integer[] siteId, Limitable limitable);

	public Page<Comment> findPage(String ftype, Integer fid, Integer creatorId,
			Integer[] status, Integer[] siteId, Pageable pageable);

	public Object getEntity(String entityName, Serializable id);

	public void flushAndRefresh(Comment entity);

}
