package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Info;

public interface InfoSpecialService {
	public void update(Info info, Integer[] specialIds);

	public void deleteBySpecialId(Integer specialId);
}
