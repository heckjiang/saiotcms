package com.saiot.cms.core.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.ScoreItem;

public interface ScoreItemDao extends Repository<ScoreItem, Integer> {
	public List<ScoreItem> findAll(Specification<ScoreItem> spec, Sort sort);

	public List<ScoreItem> findAll(Specification<ScoreItem> spec,
			Limitable limit);

	public ScoreItem findOne(Integer id);

	public ScoreItem save(ScoreItem bean);

	public void delete(ScoreItem bean);

	// --------------------

}
