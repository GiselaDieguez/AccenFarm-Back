package Gisela.demo.service;

import Gisela.demo.model.EggAmt;
import Gisela.demo.repository.iEggAmtRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EggAmtServiceTest {

    @Mock
    private iEggAmtRepository iEggAmtRepository;
    @InjectMocks
    private EggAmtService eggAmtService;
    private EggAmt eggAmt;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        eggAmt = new EggAmt();
    }

    @Test
    void showEggs() {
        when(iEggAmtRepository.showEggs()).thenReturn(Arrays.asList(eggAmt));
        assertNotNull(eggAmtService.showEggs());
    }
}