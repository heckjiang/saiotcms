package com.saiot.cms.core.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.MemberGroup;

/**
 * MemberGroupDao
 * 
 * @author jiangjun
 * 
 */
public interface MemberGroupDao extends Repository<MemberGroup, Integer> {
	public List<MemberGroup> findAll(Specification<MemberGroup> spec, Sort sort);

	public List<MemberGroup> findAll(Specification<MemberGroup> spec,
			Limitable limit);

	public List<MemberGroup> findAll(Sort sort);

	public MemberGroup findOne(Integer id);

	public MemberGroup save(MemberGroup bean);

	public void delete(MemberGroup bean);

	// --------------------

	public List<MemberGroup> findByTypeIn(Collection<Integer> type, Sort sort);
}
