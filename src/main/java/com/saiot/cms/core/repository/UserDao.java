package com.saiot.cms.core.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.core.domain.User;
import com.saiot.cms.core.repository.plus.UserDaoPlus;

/**
 * UserDao
 *
 * @author jiangjun
 */
public interface UserDao extends Repository<User, Integer>, UserDaoPlus {
    public Page<User> findAll(Specification<User> spec, Pageable pageable);

    public List<User> findAll(Specification<User> spec, Limitable limitable);

    public User findOne(Integer id);

    public User save(User bean);

    public void delete(User bean);

    // ------------------------------------

    /**
     * 查询注册用户数量
     *
     * @param beginDate 开始日期
     * @return
     */
    @Query("select count(*) from UserDetail bean where bean.creationDate >= ?1")
    public long countByDate(Date beginDate);

    public User findByUsername(String username);

    public User findByMobile(String username);

    public User findByEmail(String username);

    public User findByWeixinOpenid(String weixinOpenid);

    public User findByQqOpenid(String qqOpenid);

    public User findByWeiboUid(String weiboUid);

    public User findByValidationTypeAndValidationKey(String type, String key);

    @Query("select count(*) from User bean where bean.username=?1")
    public long countByUsername(String username);

    @Query("select count(*) from User bean where bean.org.id in ?1")
    public long countByOrgId(Collection<Integer> orgIds);

    @Query("select count(*) from User bean where bean.group.id in ?1")
    public long countByGroupId(Collection<Integer> groupIds);
}
