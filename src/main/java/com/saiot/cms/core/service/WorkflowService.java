package com.saiot.cms.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.domain.Workflow;
import com.saiot.cms.core.domain.WorkflowProcess;

/**
 * WorkflowService
 * 
 * @author jiangjun
 * 
 */
public interface WorkflowService {
	public List<Workflow> findList(Integer siteId,
			Map<String, String[]> params, Sort sort);

	public RowSide<Workflow> findSide(Integer siteId,
			Map<String, String[]> params, Workflow bean, Integer position,
			Sort sort);

	public List<Workflow> findList(Integer siteId);

	public Workflow get(Integer id);

	public String pass(Workflow workflow, User owner, User operator,
			WorkflowProcess targetProcess, Integer dataType, Integer dataId,
			String opinion, boolean anew);

	public String reject(Workflow workflow, User owner, User operator,
			WorkflowProcess targetProcess, Integer dataType, Integer dataId,
			String opinion, boolean rejectEnd);

	public Workflow save(Workflow bean, Integer groupId, Integer siteId);

	public Workflow update(Workflow bean, Integer groupId);

	public List<Workflow> batchUpdate(Integer[] id, String[] name,
			String[] description);

	public Workflow delete(Integer id);

	public Workflow[] delete(Integer[] ids);
}
