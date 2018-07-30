package com.saiot.cms.core.service;

import javax.xml.bind.JAXBException;

import com.saiot.cms.core.domain.Attribute;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * Created by PONY on 2017/7/19.
 */
public interface AttributePortService {
    public List<Attribute> importAttribute(Integer siteId, Integer userId, Reader reader) throws JAXBException;

    public void exportAttribute(Integer siteId, Writer writer) throws JAXBException, IOException;
}
