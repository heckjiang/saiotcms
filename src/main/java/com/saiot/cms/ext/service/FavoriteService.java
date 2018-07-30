package com.saiot.cms.ext.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.saiot.cms.common.orm.Limitable;
import com.saiot.cms.common.orm.RowSide;
import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.User;
import com.saiot.cms.ext.domain.Favorite;
import com.saiot.cms.ext.domain.InfoFavorite;

public interface FavoriteService {
	public Page<Favorite> findAll(Integer userId, Map<String, String[]> params, Pageable pageable);

	public List<Favorite> findAll(Integer userId, Map<String, String[]> params, Limitable limitable);

	public RowSide<Favorite> findSide(Integer userId, Map<String, String[]> params, Favorite bean, Integer position,
			Sort sort);

	public Favorite get(Integer id);

	public InfoFavorite infoFavorite(Info info, User user);

	public InfoFavorite infoUnfavorite(Info info, User user);

	public Favorite save(Favorite bean);

	public Favorite update(Favorite bean);

	public Favorite delete(Integer id);

	public List<Favorite> delete(Integer[] ids);
}
