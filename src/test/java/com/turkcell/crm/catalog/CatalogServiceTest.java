package com.turkcell.crm.catalog;

import com.turkcell.crm.catalog.entity.Catalog;
import com.turkcell.crm.catalog.repository.ICatalogRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class CatalogServiceTest {

    @MockBean
    private ICatalogRepository mockRepository;

    Catalog firstCatalog;
    Catalog secondCatalog;

    @Before
    public void init(){
        firstCatalog = new Catalog();
        secondCatalog = new Catalog();

        firstCatalog.setId(1L);
        firstCatalog.setName("HIZLI");
        firstCatalog.setSpeed(100);
        firstCatalog.setUnit("MBPS");
        firstCatalog.setPrice(new BigDecimal(299));
        firstCatalog.setCurrency("TL");

        secondCatalog.setId(2L);
        secondCatalog.setName("YAVS");
        secondCatalog.setSpeed(8);
        secondCatalog.setUnit("MBPS");
        secondCatalog.setPrice(new BigDecimal(99));
        secondCatalog.setCurrency("TL");
    }

    @Test
    public void findAllTest() {
        List<Catalog> catalogList = new ArrayList<>();
        catalogList.add(firstCatalog);
        catalogList.add(secondCatalog);
        when(mockRepository.findAll()).thenReturn(catalogList);
    }
}
