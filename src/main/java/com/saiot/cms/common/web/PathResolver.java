package com.saiot.cms.common.web;

/**
 * 路径获取接口
 * 
 * @author jiangjun
 * 
 */
public interface PathResolver {
	public String getPath(String uri);

	public String getPath(String uri, String prefix);
}
