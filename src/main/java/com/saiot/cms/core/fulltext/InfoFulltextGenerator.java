package com.saiot.cms.core.fulltext;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.Node;

public interface InfoFulltextGenerator {

	public void addDocument(Info[] beans);

	public void updateDocument(Info[] beans);

	public void deleteDocuments(Info[] beans);

	public void addDocument(Integer siteId, final Node node, Integer userId);
}
