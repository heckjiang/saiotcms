package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.InfoDetail;

/**
 * InfoDetailService
 * 
 * @author jiangjun
 * 
 */
public interface InfoDetailService {
	public InfoDetail get(Integer id);

	public InfoDetail save(InfoDetail detail, Info info);

	public InfoDetail update(InfoDetail bean, Info info);
}
