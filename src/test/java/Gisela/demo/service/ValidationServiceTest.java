package Gisela.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iValidationRepository;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ValidationServiceTest {
    @Mock
    private iValidationRepository iValidationRepository;
    @InjectMocks
    private ValidationService validationService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validationAmt() {
        when(iValidationRepository.validationAmt()).thenReturn(6);
        int result = validationService.validationAmt();
        assertEquals(6, result);
    }

    @Test
    void validationAmtEgg() {
        when(iValidationRepository.validationAmt()).thenReturn(6);
        int result = validationService.validationAmt();
        assertEquals(6, result);
    }

    @Test
    void validationAmtCash() {
        when(iValidationRepository.validationAmt()).thenReturn(6);
        int result = validationService.validationAmt();
        assertEquals(6, result);
    }

    @Test
    void validationChickenPrice() {
        when(iValidationRepository.validationAmt()).thenReturn(6);
        int result = validationService.validationAmt();
        assertEquals(6, result);
    }

    @Test
    void validationEggPrice() {
        when(iValidationRepository.validationAmt()).thenReturn(6);
        int result = validationService.validationAmt();
        assertEquals(6, result);
    }
}