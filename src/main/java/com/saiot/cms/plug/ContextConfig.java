package com.saiot.cms.plug;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.saiot.cms.common.orm.MyJpaRepositoryFactoryBean;

@Configuration
@EntityScan({ "com.saiot.cms.plug.domain" })
@EnableJpaRepositories(basePackages = { "com.saiot.cms.plug.repository" }, repositoryFactoryBeanClass = MyJpaRepositoryFactoryBean.class)
@ComponentScan({ "com.saiot.cms.plug.service.impl", "com.saiot.cms.plug.web.fore" })
public class ContextConfig {

}
