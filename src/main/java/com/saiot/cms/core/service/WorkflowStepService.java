package com.saiot.cms.core.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.WorkflowStep;

public interface WorkflowStepService {
	public List<WorkflowStep> findList(Integer workflowId,
			Map<String, String[]> params, Sort sort);

	public RowSide<WorkflowStep> findSide(Integer workflowId,
			Map<String, String[]> params, WorkflowStep bean, Integer position,
			Sort sort);

	public WorkflowStep get(Integer id);

	public WorkflowStep save(WorkflowStep bean, Integer[] roleIds,
			Integer workflowId);

	public WorkflowStep update(WorkflowStep bean, Integer[] roleIds);

	public List<WorkflowStep> batchUpdate(Integer[] id, String[] name);

	public WorkflowStep delete(Integer id);

	public WorkflowStep[] delete(Integer[] ids);

	public void delete(Collection<WorkflowStep> steps);
}
