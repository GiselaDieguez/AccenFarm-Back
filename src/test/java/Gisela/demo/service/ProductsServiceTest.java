package Gisela.demo.service;

import Gisela.demo.model.ProductsAmt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iProductsRepository;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductsServiceTest {
    @Mock
    private iProductsRepository iProductsRepository;
    @InjectMocks
    private ProductsService productsService;

    private ProductsAmt productsAmt;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productsAmt = new ProductsAmt();
    }

    @Test
    void showChickens() {
        when(iProductsRepository.showChickens()).thenReturn(Arrays.asList(productsAmt));
        assertNotNull(productsService.showChickens());
    }
}