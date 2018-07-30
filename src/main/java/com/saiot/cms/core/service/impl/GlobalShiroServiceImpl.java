package com.saiot.cms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.Global;
import com.saiot.cms.core.repository.GlobalDao;
import com.saiot.cms.core.service.GlobalShiroService;

/**
 * GlobalShiroServiceImpl
 * 
 * @author jiangjun
 * 
 */
@Service
@Transactional(readOnly = true)
public class GlobalShiroServiceImpl implements GlobalShiroService {
	public Global findUnique() {
		Global global = dao.findOne(1);
		if (global == null) {
			throw new IllegalStateException("Global not exist!");
		}
		return dao.findOne(1);
	}

	private GlobalDao dao;

	@Autowired
	public void setGlobalDao(GlobalDao dao) {
		this.dao = dao;
	}
}
