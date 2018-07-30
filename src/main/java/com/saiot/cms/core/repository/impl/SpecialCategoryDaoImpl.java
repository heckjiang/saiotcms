package com.saiot.cms.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.ArrayUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.common.orm.QuerydslUtils;
import com.saiot.cms.core.domain.SpecialCategory;
import com.saiot.cms.core.domain.dsl.QSpecialCategory;
import com.saiot.cms.core.repository.plus.SpecialCategoryDaoPlus;

/**
 * SpecialCategoryDaoImpl
 * 
 * @author jiangjun
 * 
 */
public class SpecialCategoryDaoImpl implements SpecialCategoryDaoPlus {
	public List<SpecialCategory> getList(Integer[] siteId, Limitable limitable) {
		JPAQuery<SpecialCategory> query = new JPAQuery<SpecialCategory>(this.em);
		QSpecialCategory scategory = QSpecialCategory.specialCategory;
		query.from(scategory);
		BooleanBuilder exp = new BooleanBuilder();
		if (ArrayUtils.isNotEmpty(siteId)) {
			exp = exp.and(scategory.site.id.in(siteId));
		}
		query.where(exp);
		return QuerydslUtils.list(query, scategory, limitable);

	}

	private EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
