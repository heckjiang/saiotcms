package com.saiot.cms.core.service;

import java.util.List;

/**
 * SQLService
 * 
 * @author jiangjun
 * 
 */
public interface SQLService {
	public List<?> query(String sql, Integer maxRows, Integer startRow);

	public int update(String sql);
}
