package Gisela.demo.service;

import Gisela.demo.model.Farm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iFarmRepository;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FarmServiceTest {
    @Mock
    private iFarmRepository iFarmRepository;
    @InjectMocks
    private FarmService farmService;

    private Farm farm;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        farm = new Farm();
    }

    @Test
    void buyProducts() {
        when(iFarmRepository.buyProducts()).thenReturn(Arrays.asList(farm));
        assertNotNull(farmService.buyProducts());
    }

    @Test
    void sellProducts() {
        when(iFarmRepository.sellProducts()).thenReturn(Arrays.asList(farm));
        assertNotNull(farmService.sellProducts());
    }

    @Test
    void dropProducts() {
        when(iFarmRepository.dropProducts()).thenReturn(Arrays.asList(farm));
        assertNotNull(farmService.dropProducts());
    }
}