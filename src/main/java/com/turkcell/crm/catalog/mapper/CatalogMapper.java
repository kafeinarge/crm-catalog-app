package com.turkcell.crm.catalog.mapper;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.soap.CatalogResponse;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogMapper {

    public CatalogResponse catalogToCatalogResponseSoap(Catalog catalog) {
        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setId(catalog.getId());
        catalogResponse.setName(catalog.getName());
        catalogResponse.setPrice(catalog.getPrice());

        return catalogResponse;
    }


    public GetAllCatalogResponse catalogListToCatalogListResponseSoap(List<Catalog> catalogs, GetAllCatalogResponse getAllCatalogResponse) {

        getAllCatalogResponse
                .getCatalogResponse()
                .addAll(
                        catalogs
                                .stream()
                                .map(this::catalogToCatalogResponseSoap)
                                .collect(
                                        Collectors
                                                .toList()
                                )
                );

        return getAllCatalogResponse;
    }
}
