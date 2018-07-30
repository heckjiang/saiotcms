package com.saiot.cms.plug.repository;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.plug.domain.Resume;

public interface ResumeDaoPlus {

	public List<Resume> getList(Integer[] siteId, Limitable limitable);

}
