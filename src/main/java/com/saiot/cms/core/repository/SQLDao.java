package com.saiot.cms.core.repository;

import java.util.List;

/**
 * SQLDao
 * 
 * @author jiangjun
 * 
 */
public interface SQLDao {
	public List<?> query(String sql, Integer maxRows, Integer startRow);

	public int update(String sql);
}
