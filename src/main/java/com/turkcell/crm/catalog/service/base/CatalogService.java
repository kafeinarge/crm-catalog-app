package com.turkcell.crm.catalog.service.base;

import com.turkcell.crm.catalog.enums.ErrorType;
import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.exception.ServiceFaultException;
import com.turkcell.crm.catalog.mapper.CatalogMapper;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import com.turkcell.crm.catalog.soap.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface CatalogService {

    GetAllCatalogResponse getCatalogs();
}
