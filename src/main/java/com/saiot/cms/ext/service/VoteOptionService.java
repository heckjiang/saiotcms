package com.saiot.cms.ext.service;

import com.saiot.cms.ext.domain.Vote;
import com.saiot.cms.ext.domain.VoteOption;

public interface VoteOptionService {
	public VoteOption get(Integer id);

	public VoteOption[] save(String[] title, Integer[] count, Vote vote);

	public VoteOption[] update(Integer[] id, String[] title, Integer[] count,
			Vote vote);

	public VoteOption delete(VoteOption entity);
}
