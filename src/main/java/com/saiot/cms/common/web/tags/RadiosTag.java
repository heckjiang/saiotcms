package com.saiot.cms.common.web.tags;

/**
 * RadiosTag
 * 
 * @author jiangjun
 * 
 */
public class RadiosTag extends AbstractMultiCheckedElementTag {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getInputType() {
		return "radio";
	}
}
