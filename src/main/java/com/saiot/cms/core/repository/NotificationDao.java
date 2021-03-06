package com.saiot.cms.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.Notification;
import com.saiot.cms.core.repository.plus.NotificationDaoPlus;

import java.util.Collection;
import java.util.List;

public interface NotificationDao extends Repository<Notification, Integer>, NotificationDaoPlus {
	public Page<Notification> findAll(Specification<Notification> spec, Pageable pageable);

	public List<Notification> findAll(Specification<Notification> spec, Limitable limitable);

	public Notification findOne(Integer id);

	public Notification save(Notification bean);

	public void delete(Notification bean);

	// --------------------

	public Notification findByTypeAndKeyAndReceiverId(String type, Integer key, Integer receiverId);

	public int countByReceiverId(Integer receiverId);

	/**
	 * 删除用户通知
	 * 
	 * @param userIds
	 * @return
	 */
	@Modifying
	@Query("delete from Notification bean where bean.receiver.id in (?1)")
	public int deleteByUserId(Collection<Integer> userIds);

	/**
	 * 删除用户通知来源
	 * 
	 * @param userIds
	 * @return
	 */
	@Modifying
//	@Query(value = "delete ns from cms_notification_source ns join cms_notification n on ns.notification_id_=n.notification_id_ where n.receiver_id_ in (?1)", nativeQuery = true)
	@Query(value = "delete from cms_notification_source where exists (select 1 from cms_notification n where notification_id_=n.notification_id_ and n.receiver_id_ in (?1))", nativeQuery = true)
	public int deleteNotificationSourceByUserId(Collection<Integer> userIds);
}
