package com.saiot.cms.common.orm;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JPA Specification Executor
 * 
 * @author jiangjun
 * 
 * @param <T>
 */
public interface MyJpaSpecificationExecutor<T> extends
		JpaSpecificationExecutor<T> {
	List<T> findAll(Specification<T> spec, Limitable limitable);
}
