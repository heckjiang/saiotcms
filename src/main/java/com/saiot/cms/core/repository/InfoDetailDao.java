package com.saiot.cms.core.repository;

import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.InfoDetail;

/**
 * InfoDetailDao
 * 
 * @author jiangjun
 * 
 */
public interface InfoDetailDao extends Repository<InfoDetail, Integer> {
	public InfoDetail findOne(Integer id);

	public InfoDetail save(InfoDetail bean);

}
