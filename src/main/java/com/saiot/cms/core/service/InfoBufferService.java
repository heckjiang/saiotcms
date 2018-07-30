package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.InfoBuffer;

/**
 * InfoBufferService
 * 
 * @author jiangjun
 * 
 */
public interface InfoBufferService {
	public InfoBuffer get(Integer id);

	public InfoBuffer save(InfoBuffer bean, Info info);

	public int updateViews(Integer id);

	public int updateDownloads(Integer id);

	public int updateDiggs(Integer id, Integer userId, String ip, String cookie);

	public int updateBurys(Integer id, Integer userId, String ip, String cookie);

	public int updateScore(Integer id, Integer itemId, Integer userId,
			String ip, String cookie);
}
