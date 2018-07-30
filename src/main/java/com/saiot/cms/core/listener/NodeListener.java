package com.saiot.cms.core.listener;

import com.saiot.cms.core.domain.Node;

/**
 * NodeListener
 * 
 * @author jiangjun
 * 
 */
public interface NodeListener {
	public void postNodeSave(Node[] beans);

	public void postNodeUpdate(Node[] beans);

	public void postNodeDelete(Node[] beans);
}
