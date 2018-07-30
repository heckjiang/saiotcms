package com.saiot.cms.ext.repository.plus;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.GuestbookType;

/**
 * GuestbookTypeDaoPlus
 * 
 * @author yangxing
 * 
 */
public interface GuestbookTypeDaoPlus {
	public List<GuestbookType> getList(Integer[] siteId, Limitable limitable);
}
