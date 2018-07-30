package com.saiot.cms.core.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.Global;
import com.saiot.cms.core.domain.PublishPoint;
import com.saiot.cms.core.repository.GlobalDao;
import com.saiot.cms.core.service.GlobalService;
import com.saiot.cms.core.service.PublishPointService;
import com.saiot.cms.core.support.Configurable;

/**
 * GlobalServiceImpl
 * 
 * @author jiangjun
 * 
 */
@Service
@Transactional(readOnly = true)
public class GlobalServiceImpl implements GlobalService {
	public Global findUnique() {
		Global global = dao.findOne(1);
		if (global == null) {
			throw new IllegalStateException("Global not exist!");
		}
		return dao.findOne(1);
	}

	@Transactional
	public Global update(Global bean, Integer uploadsPublishPointId) {
		PublishPoint uploadsPublishPoint = publisPointService.get(uploadsPublishPointId);
		bean.setUploadsPublishPoint(uploadsPublishPoint);
		bean = dao.save(bean);
		return bean;
	}

	@Transactional
	public void updateConf(Configurable conf) {
		Global global = findUnique();
		Map<String, String> customs = global.getCustoms();
		Global.removeAttr(customs, conf.getPrefix());
		customs.putAll(conf.getCustoms());
	}

	@Transactional
	public void updateCustoms(Global global, Map<String, String> map, Map<String, String> clobMap) {
		Map<String, String> customs = global.getCustoms();
		Global.removeAttrExcludeSys(customs);
		customs.putAll(map);
		Map<String, String> clobs = global.getClobs();
		Global.removeAttrExcludeSys(clobs);
		clobs.putAll(clobMap);
	}

	private PublishPointService publisPointService;

	@Autowired
	public void setPublisPointService(PublishPointService publisPointService) {
		this.publisPointService = publisPointService;
	}

	private GlobalDao dao;

	@Autowired
	public void setGlobalDao(GlobalDao dao) {
		this.dao = dao;
	}
}
