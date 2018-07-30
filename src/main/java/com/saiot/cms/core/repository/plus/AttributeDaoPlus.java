package com.saiot.cms.core.repository.plus;

import java.util.List;

import com.saiot.cms.core.domain.Attribute;

/**
 * AttributeDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface AttributeDaoPlus {
	public List<Attribute> findByNumbers(String[] numbers, Integer[] siteIds);
}
