package Gisela.demo.service;

import Gisela.demo.repository.iCashRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CashServiceTest {

    @InjectMocks
    private CashService cashService;

    @Test
    public void testShowCash() {
        Integer expectedCash = 1000;
        when(cashService.showCash()).thenReturn(expectedCash);
        Integer actualCash = cashService.showCash();
        assertEquals(expectedCash, actualCash);
    }
}
