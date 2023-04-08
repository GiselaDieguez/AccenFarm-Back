package Gisela.demo.service;

import Gisela.demo.repository.iEggAmtRepository;
import Gisela.demo.service.EggAmtService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EggAmtServiceTest {
    @Mock
    private iEggAmtRepository iEggAmtRepositoryMock;

    @InjectMocks
    private EggAmtService eggAmtService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(iEggAmtRepositoryMock.showEggs()).thenReturn(10);
    }

    @Test
    public void testShowEggs() {
        Integer result = eggAmtService.showEggs();
        assertEquals(Integer.valueOf(10), result);
    }
}
