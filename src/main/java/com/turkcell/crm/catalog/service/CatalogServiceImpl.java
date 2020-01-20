package com.turkcell.crm.catalog.service;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.enums.ErrorType;
import com.turkcell.crm.catalog.exception.ServiceFaultException;
import com.turkcell.crm.catalog.mapper.CatalogMapper;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import com.turkcell.crm.catalog.service.base.CatalogService;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import com.turkcell.crm.catalog.soap.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private ICatalogRepository catalogRepository;

    @Autowired
    CatalogMapper catalogMapper;

    /**
     * retrieves catalog list
     * @return GetAllCatalogResponse
     */
    @Cacheable("catalog")
    public GetAllCatalogResponse getCatalogs(){

        ResponseMessage responseMessage= new ResponseMessage();

        GetAllCatalogResponse getAllCatalogResponse = new GetAllCatalogResponse();
        List<Catalog> catalogList;
        try {
            catalogList = (List<Catalog>) catalogRepository.findAll();
        } catch (DataAccessException e){
            responseMessage.setMessage(e.getMessage());
            responseMessage.setStatusCode(ErrorType.SERVICE_ERROR.getResultCode());
            throw new ServiceFaultException("ERROR", responseMessage);
        }
        return catalogMapper.catalogListToCatalogListResponseSoap(catalogList, getAllCatalogResponse);
    }
}
