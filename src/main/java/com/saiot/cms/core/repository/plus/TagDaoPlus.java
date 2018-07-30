package com.saiot.cms.core.repository.plus;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Tag;

/**
 * TagDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface TagDaoPlus {
	public List<Tag> findList(Integer[] siteId, String[] node,
			Integer[] nodeId, Integer refers, Limitable limitable);

	public Page<Tag> findPage(Integer[] siteId, String[] node,
			Integer[] nodeId, Integer refers, Pageable pageable);

	public List<Tag> findByName(String[] names, Integer[] siteIds);
}
