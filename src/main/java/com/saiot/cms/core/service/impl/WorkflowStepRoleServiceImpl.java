package com.saiot.cms.core.service.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.Role;
import com.saiot.cms.core.domain.WorkflowStep;
import com.saiot.cms.core.domain.WorkflowStepRole;
import com.saiot.cms.core.domain.WorkflowStepRole.WorkflowStepRoleId;
import com.saiot.cms.core.listener.RoleDeleteListener;
import com.saiot.cms.core.repository.WorkflowStepRoleDao;
import com.saiot.cms.core.service.RoleService;
import com.saiot.cms.core.service.WorkflowStepRoleService;
import com.saiot.cms.core.support.DeleteException;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class WorkflowStepRoleServiceImpl implements WorkflowStepRoleService, RoleDeleteListener {

    private WorkflowStepRole findOrCreate(WorkflowStep step, Role role) {
        WorkflowStepRole bean = dao.findOne(new WorkflowStepRoleId(role.getId(), step.getId()));
        if (bean == null) {
            bean = new WorkflowStepRole(step, role);
        }
        return bean;
    }

    @Transactional
    public void update(WorkflowStep step, Integer[] roleIds) {
        List<WorkflowStepRole> stepRoles = step.getStepRoles();
        stepRoles.clear();
        if (roleIds != null) {
            for (Integer id : roleIds) {
                stepRoles.add(findOrCreate(step, roleService.get(id)));
            }
        }
    }

    public void preRoleDelete(Integer[] ids) {
        if (ArrayUtils.isNotEmpty(ids)) {
            if (dao.countByRoleId(Arrays.asList(ids)) > 0) {
                throw new DeleteException("workflowStep.management");
            }
        }
    }

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    private WorkflowStepRoleDao dao;

    @Autowired
    public void setDao(WorkflowStepRoleDao dao) {
        this.dao = dao;
    }
}
