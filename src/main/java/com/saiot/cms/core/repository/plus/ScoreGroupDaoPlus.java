package com.saiot.cms.core.repository.plus;

import com.saiot.cms.core.domain.ScoreGroup;

public interface ScoreGroupDaoPlus {
	public ScoreGroup findTopOne(Integer siteId);
}
