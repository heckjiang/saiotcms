package com.saiot.cms.core.service;

import java.util.Map;

import com.saiot.cms.core.domain.Info;

/**
 * InfoAttributeService
 * 
 * @author jiangjun
 * 
 */
public interface InfoAttributeService {
	public void update(Info info, Integer[] attrIds, Map<String, String> attrImages);

	public int deleteByAttributeId(Integer attributeId);
}
