package Gisela.demo.service;

import Gisela.demo.model.Chicken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iChickenRepository;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChickenServiceTest {
    @Mock
    private iChickenRepository iChickenRepository;
    @InjectMocks
    private ChickenService chickenService;

    private Chicken chicken;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        chicken = new Chicken();
    }

    @Test
    void buyChicken() {
        when(iChickenRepository.buyChicken()).thenReturn(Arrays.asList(chicken));
        assertNotNull(chickenService.buyChicken());
    }

    @Test
    void sellChicken() {
        when(iChickenRepository.sellChicken()).thenReturn(Arrays.asList(chicken));
        assertNotNull(chickenService.sellChicken());
    }

    @Test
    void dropChicken() {
        when(iChickenRepository.dropChicken()).thenReturn(Arrays.asList(chicken));
        assertNotNull(chickenService.dropChicken());
    }
}