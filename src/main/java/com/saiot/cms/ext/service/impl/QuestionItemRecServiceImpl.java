package com.saiot.cms.ext.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saiot.cms.ext.service.QuestionItemRecService;

@Service
@Transactional(readOnly = true)
public class QuestionItemRecServiceImpl implements QuestionItemRecService {

	// private QuestionItemRecDao dao;
	//
	// @Autowired
	// public void setDao(QuestionItemRecDao dao) {
	// this.dao = dao;
	// }
}
