package com.saiot.cms.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.Attribute;
import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.InfoAttribute;
import com.saiot.cms.core.domain.InfoAttribute.InfoAttributeId;
import com.saiot.cms.core.repository.InfoAttributeDao;
import com.saiot.cms.core.service.AttributeService;
import com.saiot.cms.core.service.InfoAttributeService;

/**
 * InfoAttributeServiceImpl
 * 
 * @author jiangjun
 * 
 */
@Service
@Transactional(readOnly = true)
public class InfoAttributeServiceImpl implements InfoAttributeService {
	private InfoAttribute findOrCreate(Info info, Attribute attr, String image) {
		InfoAttribute bean = dao.findOne(new InfoAttributeId(info.getId(), attr.getId()));
		if (bean == null) {
			bean = new InfoAttribute(info, attr);
		}
		bean.setImage(image);
		return bean;
	}

	@Transactional
	public void update(Info info, Integer[] attrIds, Map<String, String> attrImages) {
		// 为null不更新。要设置为空，请传空数组。
		if (attrIds == null) {
			return;
		}
		List<InfoAttribute> infoAttrs = info.getInfoAttrs();
		infoAttrs.clear();
		for (Integer attrId : attrIds) {
			infoAttrs.add(findOrCreate(info, attrService.get(attrId), attrImages.get(attrId.toString())));
		}
	}

	public int deleteByAttributeId(Integer attributeId) {
		return dao.deleteByAttributeId(attributeId);
	}

	private AttributeService attrService;

	@Autowired
	public void setAttrService(AttributeService attrService) {
		this.attrService = attrService;
	}

	private InfoAttributeDao dao;

	@Autowired
	public void setDao(InfoAttributeDao dao) {
		this.dao = dao;
	}
}
