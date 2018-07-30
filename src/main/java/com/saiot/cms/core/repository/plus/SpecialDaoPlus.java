package com.saiot.cms.core.repository.plus;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Special;

/**
 * SpecialDaoPlus
 * 
 * @author jiangjun
 * 
 */
public interface SpecialDaoPlus {

	public List<Special> findList(Integer[] siteId, Integer[] categoryId,
			Date beginDate, Date endDate, Boolean isWithImage,
			Boolean isRecommend, Limitable limitable);

	public Page<Special> findPage(Integer[] siteId, Integer[] categoryId,
			Date beginDate, Date endDate, Boolean isWithImage,
			Boolean isRecommend, Pageable pageable);
}
