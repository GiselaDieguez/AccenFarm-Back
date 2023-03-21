package Gisela.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Gisela.demo.repository.iChickenRepository;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ChickenServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void buyChicken() {
        iChickenRepository mockRepository = Mockito.mock(iChickenRepository.class);

        ChickenService chickenService = new ChickenService();
        chickenService.setiChickenRepository(mockRepository);

        chickenService.buyChicken();
        Mockito.verify(mockRepository, Mockito.times(1)).buyChicken();
    }

    @Test
    void sellChickenTest() {
        iChickenRepository mockRepository = Mockito.mock(iChickenRepository.class);

        ChickenService chickenService = new ChickenService();
        chickenService.setiChickenRepository(mockRepository);

        chickenService.sellChicken();

        Mockito.verify(mockRepository, Mockito.times(1)).sellChicken();
    }

    @Test
    void dropChicken() {
        iChickenRepository mockRepository = Mockito.mock(iChickenRepository.class);

        ChickenService chickenService = new ChickenService();
        chickenService.setiChickenRepository(mockRepository);

        chickenService.dropChicken();
        Mockito.verify(mockRepository, Mockito.times(1)).dropChicken();
    }
}