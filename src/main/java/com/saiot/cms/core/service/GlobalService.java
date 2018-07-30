package com.saiot.cms.core.service;

import java.util.Map;

import com.saiot.cms.core.domain.Global;
import com.saiot.cms.core.support.Configurable;

/**
 * GlobalService
 * 
 * @author jiangjun
 * 
 */
public interface GlobalService {
	public Global findUnique();

	public Global update(Global bean, Integer uploadsPublishPointId);

	public void updateConf(Configurable conf);

	public void updateCustoms(Global global, Map<String, String> map, Map<String, String> clobMap);
}
