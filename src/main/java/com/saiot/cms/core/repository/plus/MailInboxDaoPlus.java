package com.saiot.cms.core.repository.plus;

import com.saiot.cms.core.domain.MailOutbox;

public interface MailInboxDaoPlus {
	public int allReceive(MailOutbox outbox);

	public int groupReceiveGroup(MailOutbox outbox, Integer[] groupIds);
}
