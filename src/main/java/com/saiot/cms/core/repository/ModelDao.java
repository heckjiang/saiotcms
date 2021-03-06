package com.saiot.cms.core.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Model;
import com.saiot.cms.core.repository.plus.ModelDaoPlus;

import java.util.Collection;
import java.util.List;

/**
 * ModelDao
 * 
 * @author jiangjun
 * 
 */
public interface ModelDao extends Repository<Model, Integer>, ModelDaoPlus {
	public List<Model> findAll(Specification<Model> spec, Sort sort);

	public List<Model> findAll(Specification<Model> spec, Limitable limit);

	public Model findOne(Integer id);

	public Model save(Model bean);

	public void delete(Model bean);

	// --------------------

	public List<Model> findBySiteIdAndTypeAndName(Integer siteId, String type, String name);

	public List<Model> findBySiteIdIn(Collection<Integer> siteIds);

	// @Query("select count(*) from Model bean where bean.site.id in (?1)")
	// public long countBySiteId(Collection<Integer> siteIds);
}
