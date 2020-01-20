package com.turkcell.crm.catalog.repository;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.exception.ServiceFaultException;
import com.turkcell.crm.catalog.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ICatalogRepository extends BaseRepository<Catalog,Long> {

}
