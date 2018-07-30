package com.saiot.cms.ext.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.VoteOption;
import com.saiot.cms.ext.repository.plus.VoteOptionDaoPlus;

public interface VoteOptionDao extends Repository<VoteOption, Integer>, VoteOptionDaoPlus {
	public List<VoteOption> findAll(Specification<VoteOption> spec, Sort sort);

	public List<VoteOption> findAll(Specification<VoteOption> spec, Limitable limit);

	public VoteOption findOne(Integer id);

	public VoteOption save(VoteOption bean);

	public void delete(VoteOption bean);

	// --------------------

}
