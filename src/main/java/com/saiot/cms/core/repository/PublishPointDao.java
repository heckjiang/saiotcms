package com.saiot.cms.core.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.PublishPoint;
import com.saiot.cms.core.repository.plus.PublishPointDaoPlus;

public interface PublishPointDao extends Repository<PublishPoint, Integer>,
		PublishPointDaoPlus {
	public List<PublishPoint> findAll(Specification<PublishPoint> spec,
			Sort sort);

	public List<PublishPoint> findAll(Specification<PublishPoint> spec,
			Limitable limit);

	public PublishPoint findOne(Integer id);

	public PublishPoint save(PublishPoint bean);

	public void delete(PublishPoint bean);

	// --------------------

	public List<PublishPoint> findByType(Integer type, Sort sort);
}
