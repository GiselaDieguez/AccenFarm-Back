package Gisela.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ValidationServiceTest {
    @InjectMocks
    private ValidationService validationService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validationAmt() {
        when(validationService.getTotalChickens(1)).thenReturn(6);
        int result = validationService.getTotalChickens(1);
        assertEquals(6, result);
    }

    @Test
    void validationAmtEgg() {
        when(validationService.getTotalEggs(2)).thenReturn(6);
        int result = validationService.getTotalEggs(2);
        assertEquals(6, result);
    }

    @Test
    void getProductPriceChicken() {
        when(validationService.getProductPrice(1)).thenReturn(6);
        int result = validationService.getProductPrice(1);
        assertEquals(6, result);
    }

    @Test
    void getProductPriceEgg() {
        when(validationService.getProductPrice(2)).thenReturn(6);
        int result = validationService.getProductPrice(2);
        assertEquals(6, result);
    }

}