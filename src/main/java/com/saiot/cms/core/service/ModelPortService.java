package com.saiot.cms.core.service;

import javax.xml.bind.JAXBException;

import com.saiot.cms.core.domain.Model;
import com.saiot.cms.core.domain.Site;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * Created by PONY on 2017/7/17.
 */
public interface ModelPortService {
    public void exportModel(Site site, Writer writer) throws JAXBException, IOException;

    public List<Model> importModel(Integer siteId, Reader reader) throws JAXBException;
}
