package com.turkcell.crm.catalog.repository.base;

import com.turkcell.crm.catalog.entity.base.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends CrudRepository<T, ID> {
}
