package com.saiot.cms.core.fulltext;

import com.saiot.cms.core.service.TaskService;

/**
 * InfoFulltextDao
 * 
 * @author jiangjun
 * 
 */
public interface InfoFulltextDao {
	public int addDocument(Integer siteId, String treeNumber,
			TaskService taskService, Integer taskId);
}
