package com.saiot.cms.core.service;

import java.util.List;

import com.saiot.cms.core.domain.Site;

/**
 * SiteService
 * 
 * @author jiangjun
 * 
 */
public interface SiteShiroService {
	public List<Site> findByUserId(Integer userId);

	public Site findByDomain(String domain);

	public Site get(Integer id);
}
