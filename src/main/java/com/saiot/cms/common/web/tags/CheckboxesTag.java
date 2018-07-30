package com.saiot.cms.common.web.tags;

/**
 * CheckboxesTag
 * 
 * @author jiangjun
 * 
 */
public class CheckboxesTag extends AbstractMultiCheckedElementTag {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getInputType() {
		return "checkbox";
	}
}
