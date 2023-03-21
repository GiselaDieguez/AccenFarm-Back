package Gisela.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Gisela.demo.repository.iBirthRepository;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class BirthServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void birthChicken() {
        iBirthRepository mockRepository = Mockito.mock(iBirthRepository.class);

        BirthService birthService = new BirthService();
        birthService.setiBirthRepository(mockRepository);

        birthService.birthChicken();
        Mockito.verify(mockRepository, Mockito.times(1)).birthChicken();

    }

    @Test
    void birthEgg() {
        iBirthRepository mockRepository = Mockito.mock(iBirthRepository.class);

        BirthService birthService = new BirthService();
        birthService.setiBirthRepository(mockRepository);

        birthService.birthEgg();
        Mockito.verify(mockRepository, Mockito.times(1)).birthEgg();
    }
}