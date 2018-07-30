package com.saiot.cms.core.html;

import java.io.IOException;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.Node;

import freemarker.template.TemplateException;

/**
 * HtmlService
 * 
 * @author jiangjun
 * 
 */
public interface HtmlService {
	public void makeInfo(Integer infoId);

	public void makeInfo(Info info);

	public void deleteInfo(Info info);

	public void makeNode(Integer nodeId);

	public void makeNode(Node node);

	public void makeHome(Integer siteId) throws IOException, TemplateException;

	public Integer makeNode(Integer siteId, Integer nodeId,
			boolean includeChildren, Integer taskId, boolean forUpdate,
			Integer lastId, int maxResult) throws IOException,
			TemplateException;

	public Integer makeInfo(Integer siteId, Integer nodeId,
			boolean includeChildren, Integer taskId, boolean forUpdate,
			Integer lastId, int maxResult) throws IOException,
			TemplateException;
}
