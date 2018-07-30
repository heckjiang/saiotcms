package com.saiot.cms.ext.repository.plus;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.Ad;

/**
 * AdDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface AdDaoPlus {
	public List<Ad> findList(Integer[] siteId, String[] slot, Integer[] slotId,
			Limitable limitable);
}
