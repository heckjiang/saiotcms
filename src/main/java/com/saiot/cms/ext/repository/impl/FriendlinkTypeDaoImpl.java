package com.saiot.cms.ext.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.jpa.QueryHints;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.common.orm.QuerydslUtils;
import com.saiot.cms.ext.domain.FriendlinkType;
import com.saiot.cms.ext.domain.dsl.QFriendlinkType;
import com.saiot.cms.ext.repository.plus.FriendlinkTypeDaoPlus;

/**
 * FriendlinkTypeDaoImpl
 * 
 * @author yangxing
 * 
 */
public class FriendlinkTypeDaoImpl implements FriendlinkTypeDaoPlus {

	public List<FriendlinkType> getList(Integer[] siteId, Limitable limitable) {
		JPAQuery<FriendlinkType> query = new JPAQuery<FriendlinkType>(this.em);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		QFriendlinkType friendlinkType = QFriendlinkType.friendlinkType;
		query.from(friendlinkType);
		BooleanBuilder exp = new BooleanBuilder();
		if (ArrayUtils.isNotEmpty(siteId)) {
			exp = exp.and(friendlinkType.site.id.in(siteId));
		}
		query.where(exp);
		return QuerydslUtils.list(query, friendlinkType, limitable);
	}

	private EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
