package com.saiot.cms.core.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.OperationLog;

public interface OperationLogService {
	public Page<OperationLog> findAll(Integer siteId,
			Map<String, String[]> params, Pageable pageable);

	public RowSide<OperationLog> findSide(Integer siteId,
			Map<String, String[]> params, OperationLog bean, Integer position,
			Sort sort);

	public OperationLog get(Integer id);

	public OperationLog operation(String name, String description, String text,
			Integer dataId, String ip, Integer userId, Integer siteId);

	public OperationLog operation(String name, String description, String text,
			Integer dataId, HttpServletRequest request);

	public OperationLog loginSuccess(String ip, Integer userId);

	public OperationLog loginFailure(String description, String ip);

	public OperationLog logout(String ip, String username);

	public OperationLog delete(Integer id);

	public List<OperationLog> delete(Integer[] ids);
}
