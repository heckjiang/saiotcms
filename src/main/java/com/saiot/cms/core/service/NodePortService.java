package com.saiot.cms.core.service;

import javax.xml.bind.JAXBException;

import com.saiot.cms.core.domain.Node;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * Created by PONY on 2017/7/17.
 */
public interface NodePortService {

    public List<Node> importNode(Integer siteId, Integer userId, Reader reader) throws JAXBException;

    public void exportNode(Integer siteId, Writer writer) throws JAXBException, IOException;
}
