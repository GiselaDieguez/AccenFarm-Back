package Gisela.demo.service;

import Gisela.demo.model.Egg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iEggRepository;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EggServiceTest {
    @Mock
    private iEggRepository iEggRepository;
    @InjectMocks
    private EggService eggService;

    private Egg egg;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        egg = new Egg();
    }

    @Test
    void buyEggs() {
        when(iEggRepository.buyEggs()).thenReturn(Arrays.asList(egg));
        assertNotNull(eggService.buyEggs());
    }

    @Test
    void sellEggs() {
        when(iEggRepository.sellEggs()).thenReturn(Arrays.asList(egg));
        assertNotNull(eggService.sellEggs());
    }

    @Test
    void dropEggs() {
        when(iEggRepository.dropEggs()).thenReturn(Arrays.asList(egg));
        assertNotNull(eggService.dropEggs());
    }
}