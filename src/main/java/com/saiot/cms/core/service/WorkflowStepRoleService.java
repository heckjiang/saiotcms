package com.saiot.cms.core.service;

import com.saiot.cms.core.domain.WorkflowStep;

public interface WorkflowStepRoleService {
	public void update(WorkflowStep step, Integer[] roleIds);
}
