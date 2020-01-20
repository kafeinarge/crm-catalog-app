package com.turkcell.crm.catalog.controller;

import com.turkcell.crm.catalog.exception.ServiceFaultException;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import com.turkcell.crm.catalog.service.CatalogService;
import com.turkcell.crm.catalog.soap.GetAllCatalogRequest;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import com.turkcell.crm.catalog.soap.GetCatalogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CatalogController {

    private static final String NAMESPACE_URI = "http://www.turkcell.com/crm/catalog/soap";

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCatalogRequest")
    @ResponsePayload
    public GetAllCatalogResponse getCatalogs(@RequestPayload GetAllCatalogRequest request) {
        return catalogService.getCatalogs();
    }

}
