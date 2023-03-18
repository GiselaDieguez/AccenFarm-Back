package Gisela.demo.service;

import Gisela.demo.model.Cash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iCashRepository;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CashServiceTest {
    @Mock
    private iCashRepository iCashRepository;

    @InjectMocks
    private CashService cashService;

    private Cash cash;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cash = new Cash();
    }

    @Test
    void showCash() {
        when(iCashRepository.showCash()).thenReturn(Arrays.asList(cash));
        assertNotNull(cashService.showCash());
    }
}