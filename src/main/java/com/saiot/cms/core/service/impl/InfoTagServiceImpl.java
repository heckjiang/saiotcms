package com.saiot.cms.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.core.domain.Info;
import com.saiot.cms.core.domain.InfoTag;
import com.saiot.cms.core.domain.Tag;
import com.saiot.cms.core.domain.InfoTag.InfoTagId;
import com.saiot.cms.core.repository.InfoTagDao;
import com.saiot.cms.core.service.InfoTagService;
import com.saiot.cms.core.service.TagService;

@Service
@Transactional(readOnly = true)
public class InfoTagServiceImpl implements InfoTagService {
	private InfoTag findOrCreate(Info info, Tag tag) {
		InfoTag bean = dao.findOne(new InfoTagId(info.getId(), tag.getId()));
		if (bean == null) {
			bean = new InfoTag(info, tag);
		}
		return bean;
	}

	@Transactional
	public void update(Info info, String[] tagNames) {
		// 为null不更新。要设置为空，请传空数组。
		if (tagNames == null) {
			return;
		}
		List<InfoTag> infoTags = info.getInfoTags();
		for (InfoTag infoTag : infoTags) {
			infoTag.getTag().derefer();
		}
		infoTags.clear();
		Integer siteId = info.getSite().getId();
		for (String tagName : tagNames) {
			infoTags.add(findOrCreate(info, tagService.refer(tagName, siteId)));
		}
	}

	@Transactional
	public void deleteByTagId(Integer tagId) {
		Tag tag = tagService.get(tagId);
		for(Info info : dao.findByInfoTagsTagId(tagId)) {
			InfoTag infoTag = new InfoTag(info,tag);
			info.getInfoTags().remove(infoTag);
			dao.delete(infoTag);
		}
	}

	private TagService tagService;

	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	private InfoTagDao dao;

	@Autowired
	public void setDao(InfoTagDao dao) {
		this.dao = dao;
	}
}
