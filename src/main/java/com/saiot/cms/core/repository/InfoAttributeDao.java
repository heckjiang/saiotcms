package com.saiot.cms.core.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.saiot.cms.core.domain.InfoAttribute;
import com.saiot.cms.core.domain.InfoAttribute.InfoAttributeId;

/**
 * InfoAttributeDao
 * 
 * @author jiangjun
 * 
 */
public interface InfoAttributeDao extends Repository<InfoAttribute, InfoAttributeId> {
	public InfoAttribute findOne(InfoAttributeId id);

	// --------------------

	@Modifying
	@Query("delete from InfoAttribute t where t.attribute.id=?1")
	public int deleteByAttributeId(Integer attributeId);
}
