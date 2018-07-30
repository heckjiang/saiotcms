package com.saiot.cms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.InfoDetail;
import com.saiot.cms.core.repository.InfoDetailDao;
import com.saiot.cms.core.service.InfoDetailService;

/**
 * InfoDetailServiceImpl
 * 
 * @author jiangjun
 * 
 */
@Service
@Transactional(readOnly = true)
public class InfoDetailServiceImpl implements InfoDetailService {
	public InfoDetail get(Integer id) {
		return dao.findOne(id);
	}

	@Transactional
	public InfoDetail save(InfoDetail detail, Info info) {
		info.setDetail(detail);
		detail.setInfo(info);
		detail.applyDefaultValue();
		dao.save(detail);
		return detail;
	}

	@Transactional
	public InfoDetail update(InfoDetail bean, Info info) {
		bean.setInfo(info);
		bean.applyDefaultValue();
		bean = dao.save(bean);
		info.setDetail(bean);
		return bean;
	}

	private InfoDetailDao dao;

	@Autowired
	public void setDao(InfoDetailDao dao) {
		this.dao = dao;
	}
}
