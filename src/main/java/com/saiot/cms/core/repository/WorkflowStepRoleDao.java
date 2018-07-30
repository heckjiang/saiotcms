package com.saiot.cms.core.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.WorkflowStepRole;
import com.saiot.cms.core.domain.WorkflowStepRole.WorkflowStepRoleId;

public interface WorkflowStepRoleDao extends Repository<WorkflowStepRole, WorkflowStepRoleId> {
	public WorkflowStepRole findOne(WorkflowStepRoleId id);

	// --------------------

	@Query("select count(*) from WorkflowStepRole bean where bean.role.id in (?1)")
	public long countByRoleId(Collection<Integer> roleIds);
}
