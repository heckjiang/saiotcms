package com.saiot.cms.core.service;

import javax.xml.bind.JAXBException;

import com.saiot.cms.core.domain.Info;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * Created by PONY on 2017/7/17.
 */
public interface InfoPortService {

    public List<Info> importInfo(Integer siteId, Integer userId, Reader reader) throws JAXBException;

    public void exportInfo(Integer siteId, Writer writer) throws JAXBException, IOException;
}
