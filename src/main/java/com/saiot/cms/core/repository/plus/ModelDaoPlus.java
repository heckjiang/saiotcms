package com.saiot.cms.core.repository.plus;

import java.util.List;

import com.saiot.cms.core.domain.Model;

/**
 * ModelDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface ModelDaoPlus {
	public List<Model> findList(Integer siteId, String type);

	public Model findDefault(Integer siteId, String type);

	public List<Model> findByNumbers(String[] numbers, Integer[] siteIds);
}
