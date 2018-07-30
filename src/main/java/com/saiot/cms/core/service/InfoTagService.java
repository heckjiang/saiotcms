package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Info;

public interface InfoTagService {
	public void update(Info info, String[] tagNames);

	public void deleteByTagId(Integer tagId);
}
