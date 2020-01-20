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
        firstCatalog.setName("HIZLI");
        firstCatalog.setSpeed(100);
        firstCatalog.setUnit("MBPS");
        firstCatalog.setPrice(new BigDecimal(299));
        firstCatalog.setCurrency("TL");

        secondCatalog.setId(2L);
        secondCatalog.setName("YAVAS");
        secondCatalog.setSpeed(8);
        secondCatalog.setUnit("MBPS");
        secondCatalog.setPrice(new BigDecimal(99));
        secondCatalog.setCurrency("TL");

        List<Catalog> catalogList = new ArrayList<>();
        catalogList.add(firstCatalog);
        catalogList.add(secondCatalog);

        CatalogResponse firstCatalogResponse = new CatalogResponse();
        firstCatalogResponse.setName("HIZLI");
        firstCatalogResponse.setSpeed(100);
        firstCatalogResponse.setUnit("MBPS");
        firstCatalogResponse.setPrice(new BigDecimal(299));
        firstCatalogResponse.setCurrency("TL");

        CatalogResponse secondCatalogResponse = new CatalogResponse();
        secondCatalogResponse.setName("YAVAS");
        secondCatalogResponse.setSpeed(8);
        secondCatalogResponse.setUnit("MBPS");
        secondCatalogResponse.setPrice(new BigDecimal(99));
        secondCatalogResponse.setCurrency("TL");

        List<CatalogResponse> catalogResponses = new ArrayList<>();
        catalogResponses.add(firstCatalogResponse);
        catalogResponses.add(secondCatalogResponse);

        GetAllCatalogResponse getAllCatalogResponse = new GetAllCatalogResponse();
        getAllCatalogResponse.getCatalogResponse();

        //when
        when(catalogRepository.findAll()).thenReturn(catalogList);
        when(catalogMapper.catalogToCatalogResponseSoap(firstCatalog)).thenReturn(firstCatalogResponse);

        //then
        Assert.assertEquals(catalogMapper.catalogListToCatalogListResponseSoap(catalogList,getAllCatalogResponse), catalogService.getCatalogs());
    }




}
