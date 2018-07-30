package com.saiot.cms.core.repository.plus;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.SpecialCategory;

/**
 * SpecialCategoryDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface SpecialCategoryDaoPlus {
	public List<SpecialCategory> getList(Integer[] siteId, Limitable limitable);
}
