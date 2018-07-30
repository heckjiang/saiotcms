package com.saiot.cms.ext.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.ext.domain.AdSlot;

public interface AdSlotService {
	public List<AdSlot> findList(Integer siteId, Map<String, String[]> params,
			Sort sort);

	public RowSide<AdSlot> findSide(Integer siteId,
			Map<String, String[]> params, AdSlot bean, Integer position,
			Sort sort);

	public List<AdSlot> findList(Integer siteId);

	public List<AdSlot> findList(String number, Integer siteId);

	public AdSlot get(Integer id);

	public AdSlot save(AdSlot bean, Integer siteId);

	public AdSlot update(AdSlot bean);

	public AdSlot delete(Integer id);

	public AdSlot[] delete(Integer[] ids);
}
