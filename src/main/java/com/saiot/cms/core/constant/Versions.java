package com.saiot.cms.core.constant;

import com.saiot.cms.core.commercial.Enterprise;

public class Versions {
	/**
	 * 当前版本
	 */
	public static final String VERSION = "9.0.0";

	/**
	 * 当前版本
	 * 
	 * @return
	 */
	public static String getVersion() {
		return Enterprise.isEp() ? VERSION + "-enterprise" : VERSION;
	}

}
