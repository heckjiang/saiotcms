package com.saiot.cms.core.repository.plus;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Site;

/**
 * SiteDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface SiteDaoPlus {
	public List<Site> findByStatus(Integer parentId, String parentNumber, Integer[] status, Limitable limitable);
}
