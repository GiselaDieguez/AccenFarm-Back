package Gisela.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Gisela.demo.repository.iEggRepository;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class EggServiceTest {
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void buyEggs() {
        iEggRepository mockRepository = Mockito.mock(iEggRepository.class);

        EggService eggService = new EggService();
        eggService.setiEggRepository(mockRepository);

        eggService.buyEggs();
        Mockito.verify(mockRepository, Mockito.times(1)).buyEggs();
    }

    @Test
    void sellEggs() {
        iEggRepository mockRepository = Mockito.mock(iEggRepository.class);

        EggService eggService = new EggService();
        eggService.setiEggRepository(mockRepository);

        eggService.sellEggs();
        Mockito.verify(mockRepository, Mockito.times(1)).sellEggs();
    }

    @Test
    void dropEggs() {
        iEggRepository mockRepository = Mockito.mock(iEggRepository.class);

        EggService eggService = new EggService();
        eggService.setiEggRepository(mockRepository);

        eggService.dropEggs();
        Mockito.verify(mockRepository, Mockito.times(1)).dropEggs();
    }
}