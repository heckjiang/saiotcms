package com.saiot.cms.core.repository.impl;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import com.querydsl.jpa.hibernate.HibernateQuery;
import com.saiot.cms.core.domain.MailInbox;
import com.saiot.cms.core.domain.MailOutbox;
import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.domain.dsl.QUser;
import com.saiot.cms.core.repository.plus.MailInboxDaoPlus;

public class MailInboxDaoImpl implements MailInboxDaoPlus {
	public int allReceive(MailOutbox outbox) {
		return receive(outbox, null);
	}

	public int groupReceiveGroup(MailOutbox outbox, Integer[] groupIds) {
		if (ArrayUtils.isEmpty(groupIds)) {
			return 0;
		}
		return receive(outbox, groupIds);
	}

	private int receive(MailOutbox outbox, Integer[] groupIds) {
		int batchSize = 25;
		Session session = em.unwrap(Session.class);
		QUser u = QUser.user;
		HibernateQuery<User> q = new HibernateQuery<User>(session);
		q.from(u);
		if (ArrayUtils.isNotEmpty(groupIds)) {
			q.where(u.group.id.in(groupIds));
		}
		Query query = q.createQuery();
		ScrollableResults scrollableResults = query.setCacheMode(CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
		int count = 0;
		while (scrollableResults.next()) {
			User user = (User) scrollableResults.get(0);
			// 匿名用户不发送
			if (user.isAnonymous()) {
				continue;
			}
			MailInbox bean = new MailInbox(outbox);
			bean.setReceiver(user);
			bean.applyDefaultValue();
			em.persist(bean);
			if (++count % batchSize == 0) {
				em.flush();
				em.clear();
			}
		}
		return count;
	}

	private EntityManager em;

	@javax.persistence.PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
