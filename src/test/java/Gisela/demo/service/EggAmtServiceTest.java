package Gisela.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EggAmtServiceTest {

    @InjectMocks
    private EggAmtService eggAmtService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(eggAmtService.getTotalEggs()).thenReturn(10);
    }

    @Test
    public void testShowEggs() {
        Integer result = eggAmtService.getTotalEggs();
        assertEquals(Integer.valueOf(10), result);
    }
}
