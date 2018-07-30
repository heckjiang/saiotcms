package com.saiot.cms.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.MailInbox;
import com.saiot.cms.core.domain.MailOutbox;

public interface MailInboxService {
	public Page<MailInbox> findAll(Integer receiverId, Map<String, String[]> params, Pageable pageable);

	public List<MailInbox> findAll(Integer receiverId, Map<String, String[]> params, Limitable limitable);

	public RowSide<MailInbox> findSide(Integer receiverId, Map<String, String[]> params, MailInbox bean,
			Integer position, Sort sort);

	public int receive(MailOutbox outbox, String receiverUsername, Integer[] receiverGroupIds, boolean allReceive);

	public void read(Integer id);

	public MailInbox get(Integer id);

	public MailInbox save(MailInbox bean);

	public MailInbox update(MailInbox bean);

	public MailInbox delete(Integer id);

	public List<MailInbox> delete(Integer[] ids);
}
