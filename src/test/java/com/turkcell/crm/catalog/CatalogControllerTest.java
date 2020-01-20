package com.turkcell.crm.catalog;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import com.turkcell.crm.catalog.service.CatalogService;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CatalogControllerTest {

    @InjectMocks
    private CatalogService catalogService;

    @InjectMocks
    private ICatalogRepository catalogRepository;

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ResourceLoader resourceLoader;
    /*private MockWebServiceClient mockClient;
    private Resource schema = new ClassPathResource("countries.xsd");*/

    @Test
    public void endPointTest() {

    }

}
