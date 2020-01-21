package com.turkcell.crm.catalog.service;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.mapper.CatalogMapper;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import com.turkcell.crm.catalog.soap.CatalogResponse;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class CatalogServiceImplTest {

    @InjectMocks
    private CatalogServiceImpl catalogService;

    @Mock
    private ICatalogRepository catalogRepository;

    @Mock
    private CatalogMapper catalogMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCatalogs() {
        Catalog firstCatalog = new Catalog();
        Catalog secondCatalog = new Catalog();

        firstCatalog.setId(1L);

        secondCatalog.setId(2L);

        List<Catalog> catalogList = new ArrayList<>();
        catalogList.add(firstCatalog);
        catalogList.add(secondCatalog);

        CatalogResponse firstCatalogResponse = new CatalogResponse();
        firstCatalogResponse.setId(1L);

        CatalogResponse secondCatalogResponse = new CatalogResponse();
        secondCatalogResponse.setId(1L);

        List<CatalogResponse> catalogResponses = new ArrayList<>();
        catalogResponses.add(firstCatalogResponse);
        catalogResponses.add(secondCatalogResponse);

        GetAllCatalogResponse getAllCatalogResponse = new GetAllCatalogResponse();
        getAllCatalogResponse.getCatalogResponse();

        //when
        when(catalogRepository.findAllBy()).thenReturn(java.util.Optional.of(catalogList));
        when(catalogMapper.catalogToCatalogResponseSoap(firstCatalog)).thenReturn(firstCatalogResponse);

        //then
        Assert.assertEquals(catalogMapper.catalogListToCatalogListResponseSoap(catalogList,getAllCatalogResponse), catalogService.getCatalogs());
    }




}
