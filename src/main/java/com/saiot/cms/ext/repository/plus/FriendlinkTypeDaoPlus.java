package com.saiot.cms.ext.repository.plus;

import java.util.List;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.FriendlinkType;
/**
 * FriendlinkTypeDaoPlus
 * 
 * @author yangxing
 * 
 */
public interface FriendlinkTypeDaoPlus {
	public List<FriendlinkType> getList(Integer[] siteId, Limitable limitable);
}
