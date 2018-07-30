package com.saiot.cms.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.Org;

/**
 * OrgService
 * 
 * @author jiangjun
 * 
 */
public interface OrgService {
	public List<Org> findList(String topTreeNumber, Integer parentId,
			boolean showDescendants, Map<String, String[]> params, Sort sort);

	public RowSide<Org> findSide(String topTreeNumber, Integer parentId,
			boolean showDescendants, Map<String, String[]> params, Org bean,
			Integer position, Sort sort);

	public List<Org> findList();

	public List<Org> findList(String treeNumber);

	public Org findRoot();

	public Org get(Integer id);

	public Org save(Org bean, Integer parentId);

	public Org update(Org bean, Integer parentId);

	public Org[] batchUpdate(Integer[] id, String[] name, String[] number,
			String[] phone, String[] address, boolean isUpdateTree);

	public Org delete(Integer id);

	public Org[] delete(Integer[] ids);

	public int move(Integer[] ids, Integer id);
}
