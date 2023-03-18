package Gisela.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iValidationRepository;
import org.mockito.MockitoAnnotations;


import static org.mockito.ArgumentMatchers.*;
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
        when(iValidationRepository.validationAmt()).thenReturn(anyInt());
    }

    @Test
    void validationAmtEgg() {
        when(iValidationRepository.validationAmtEgg()).thenReturn(anyInt());
    }

    @Test
    void validationAmtCash() {
        when(iValidationRepository.validationAmtCash()).thenReturn(anyInt());
    }

    @Test
    void validationChickenPrice() {
        when(iValidationRepository.validationChickenPrice()).thenReturn(anyInt());
    }

    @Test
    void validationEggPrice() {
        when(iValidationRepository.validationEggPrice()).thenReturn(anyInt());
    }
}