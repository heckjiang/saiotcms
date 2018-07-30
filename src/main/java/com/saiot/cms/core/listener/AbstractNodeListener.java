package com.saiot.cms.core.listener;

import com.saiot.cms.core.domain.Node;

/**
 * AbstractNodeListener
 * 
 * @author jiangjun
 * 
 */
public abstract class AbstractNodeListener implements NodeListener,
		NodeDeleteListener {
	public void postNodeSave(Node[] beans) {
	}

	public void postNodeUpdate(Node[] beans) {
	}

	public void preNodeDelete(Integer[] ids) {
	}

	public void postNodeDelete(Node[] beans) {
	}
}
