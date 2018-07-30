package com.saiot.cms.core.listener;

import com.saiot.cms.core.domain.Info;

/**
 * AbstractUserListener
 * 
 * @author jiangjun
 * 
 */
public abstract class AbstractUserListener implements UserDeleteListener {
	public void postSave(Info[] beans) {
	}

	public void postUpdate(Info[] beans) {
	}

	public void preUserDelete(Integer[] ids) {
	}

	public void postDelete(Info[] beans) {
	}
}
