package com.turkcell.crm.catalog.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class CatalogTest {

    private Catalog catalog;

    @Before
    public void setUp() {
        catalog = new Catalog();
        catalog.setId(1L);
        catalog.setName("MAXPRO");
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertNotNull(catalog.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(catalog.toString());
    }

    @Test
    public void equalsTest() {
        Catalog documentToCompare = createCatalog();
        Catalog nullRequest = null;
        Object nullObject = null;
        Assertions.assertTrue(documentToCompare.equals(catalog) && catalog.equals(documentToCompare));
        assertFalse(catalog.equals(nullRequest));
        assertFalse(catalog.equals(nullObject));
    }

    private Catalog createCatalog() {
        Catalog customer = new Catalog();
        customer.setId(1L);
        customer.setName("MAXPRO");
        return customer;
    }
}
