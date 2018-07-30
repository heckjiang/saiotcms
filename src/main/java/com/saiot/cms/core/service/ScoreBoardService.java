package com.saiot.cms.core.service;

import java.util.List;

import com.saiot.cms.core.domain.ScoreBoard;

public interface ScoreBoardService {

	public List<ScoreBoard> findList(String ftype, Integer fid);

	public ScoreBoard findOne(String ftype, Integer fid, Integer itemId);

	public ScoreBoard scoring(String ftype, Integer fid, Integer itemId);

	public ScoreBoard get(Integer id);

	public ScoreBoard save(ScoreBoard bean);

	public ScoreBoard update(ScoreBoard bean);

	public ScoreBoard delete(Integer id);

	public ScoreBoard[] delete(Integer[] ids);
}
