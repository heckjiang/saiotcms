package com.saiot.cms.ext.repository.plus;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.Friendlink;

/**
 * FriendlinkDaoPlus
 * 
 * @author yangxing
 * 
 */
public interface FriendlinkDaoPlus {
	public List<Friendlink> findList(Integer[] siteId, String[] type, Integer[] typeId,
			Boolean isWithLogo, Boolean isRecommend, Integer[] status, Limitable limitable);
}
