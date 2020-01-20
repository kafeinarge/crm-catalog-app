package com.turkcell.crm.catalog.service;

import com.turkcell.crm.catalog.enums.ErrorType;
import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.exception.ServiceFaultException;
import com.turkcell.crm.catalog.mapper.CatalogMapper;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import com.turkcell.crm.catalog.soap.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private ICatalogRepository catalogRepository;

    @Autowired
    CatalogMapper catalogMapper;

    /**
     * retrieves catalog list
     * @return GetAllCatalogResponse
     */
    @Cacheable("catalog")
    public GetAllCatalogResponse getCatalogs() throws  ServiceFaultException{

        ResponseMessage responseMessage= new ResponseMessage();
        responseMessage.setMessage("Catalogs cannot be retrieved");
        responseMessage.setStatusCode(ErrorType.SERVICE_ERROR.getResultCode());

        GetAllCatalogResponse getAllCatalogResponse = new GetAllCatalogResponse();
        List<Catalog> catalogList = new ArrayList<>();
        try {
            catalogList = (List<Catalog>) catalogRepository.findAll();
        } catch (Exception e){
            throw new ServiceFaultException("ERROR", responseMessage);
        }
        return catalogMapper.catalogListToCatalogListResponseSoap(catalogList, getAllCatalogResponse);
    }
}
