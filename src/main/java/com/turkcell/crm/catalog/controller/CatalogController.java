package com.turkcell.crm.catalog.controller;

import com.turkcell.crm.catalog.service.CatalogServiceImpl;
import com.turkcell.crm.catalog.soap.GetAllCatalogRequest;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CatalogController {

    private static final String NAMESPACE_URI = "http://www.turkcell.com/crm/catalog/soap";

    private final CatalogServiceImpl catalogServiceImpl;

    public CatalogController(CatalogServiceImpl catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCatalogRequest")
    @ResponsePayload
    public GetAllCatalogResponse getCatalogs(@RequestPayload GetAllCatalogRequest request) {
        return catalogServiceImpl.getCatalogs();
    }

}
