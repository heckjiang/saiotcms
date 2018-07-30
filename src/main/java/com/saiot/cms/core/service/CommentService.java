package com.saiot.cms.core.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.Comment;

/**
 * CommentService
 * 
 * @author jiangjun
 * 
 */
public interface CommentService {
	public Page<Comment> findAll(Integer siteId, Map<String, String[]> params, Pageable pageable);

	public RowSide<Comment> findSide(Integer siteId, Map<String, String[]> params, Comment bean, Integer position,
			Sort sort);

	public List<Comment> findList(String ftype, Integer fid, Integer creatorId, Integer[] status, Integer[] siteId,
			Limitable limitable);

	public Page<Comment> findPage(String ftype, Integer fid, Integer creatorId, Integer[] status, Integer[] siteId,
			Pageable pageable);

	public long countByDate(Integer siteId, Date beginDate);

	public Object getEntity(String entityName, Serializable id);

	public Comment get(Integer id);

	public Comment save(Comment bean, Integer userId, Integer siteId, Integer parentId);

	public Comment update(Comment bean);

	public Comment delete(Integer id);

	public Comment[] delete(Integer[] ids);

	public int deleteByFtypeAndFid(String ftype, Integer fid);

	public Comment[] audit(Integer[] ids);

	public Comment[] unaudit(Integer[] ids);
}
