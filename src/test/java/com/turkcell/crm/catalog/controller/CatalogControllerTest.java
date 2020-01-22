package com.turkcell.crm.catalog.controller;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.mapper.CatalogMapper;
import com.turkcell.crm.catalog.service.CatalogServiceImpl;
import com.turkcell.crm.catalog.soap.CatalogResponse;
import com.turkcell.crm.catalog.soap.GetAllCatalogRequest;
import com.turkcell.crm.catalog.soap.GetAllCatalogResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatalogControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CatalogController catalogController;

    @Mock
    private CatalogServiceImpl catalogService;

    @Mock
    private CatalogMapper catalogMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(catalogController).build();
    }

    @Test
    public void getCatalog() throws Exception {

        when(catalogService.getCatalogs()).thenReturn(createCatalog());
        GetAllCatalogRequest getAllCatalogRequest=new GetAllCatalogRequest();
        assertEquals(createCatalog().getCatalogResponse().get(0).getId(), catalogController.getCatalogs(getAllCatalogRequest).getCatalogResponse().get(0).getId());
    }

    private GetAllCatalogResponse createCatalog(){
        Catalog catalog = new Catalog();
        catalog.setId(1L);

        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setId(1L);

        List<Catalog> list = new ArrayList<>();
        list.add(catalog);

        GetAllCatalogResponse getAllCatalogResponse = new GetAllCatalogResponse();
        mapToResponse(list,getAllCatalogResponse);
        return getAllCatalogResponse;
    }

    private GetAllCatalogResponse mapToResponse(List<Catalog> catalogs, GetAllCatalogResponse getAllCatalogResponse){
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

    public CatalogResponse catalogToCatalogResponseSoap(Catalog catalog) {
        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setId(catalog.getId());
        catalogResponse.setName(catalog.getName());
        catalogResponse.setPrice(catalog.getPrice());

        return catalogResponse;
    }
}
