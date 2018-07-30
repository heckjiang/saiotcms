package com.saiot.cms.ext.repository.plus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.ext.domain.Vote;

import java.util.List;

public interface VoteDaoPlus {
    /**
     * 查询投票列表
     *
     * @param number    投票编码
     * @param inPeriod  是否在投票开放期。即投票已经开始且未结束
     * @param status    投票状态
     * @param siteId    站点ID
     * @param limitable
     * @return
     */
    public List<Vote> findList(String[] number, Boolean inPeriod, Integer[] status, Integer[] siteId, Limitable limitable);

    /**
     * 查询投票分页
     *
     * @param inPeriod 是否在投票开放期。即投票已经开始且未结束
     * @param status   投票状态
     * @param siteId   站点ID
     * @param pageable
     * @return
     */
    public Page<Vote> findPage(String[] number, Boolean inPeriod, Integer[] status, Integer[] siteId, Pageable pageable);

    /**
     * 查询排列最前的投票
     *
     * @param siteId
     * @return
     */
    public Vote findLatest(Integer[] status, Integer siteId);

    /**
     * 按编码查询投票
     *
     * @param number
     * @param siteId
     * @return
     */
    public Vote findByNumber(String number, Integer[] status, Integer siteId);
}
