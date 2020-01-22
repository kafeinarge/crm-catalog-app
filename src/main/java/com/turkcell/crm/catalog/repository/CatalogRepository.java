package com.turkcell.crm.catalog.repository;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends BaseRepository<Catalog,Long> {

    Optional<List<Catalog>> findAllBy();
}
