package Gisela.demo.service;

import Gisela.demo.model.Birth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iBirthRepository;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BirthServiceTest {
    @Mock
    private iBirthRepository iBirthRepository;
    @InjectMocks
    private BirthService birthService;

    private Birth birth;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        birth = new Birth();
    }

    @Test
    void birthChicken() {
        when(iBirthRepository.birthChicken()).thenReturn(Arrays.asList(birth));
        assertNotNull(birthService.birthChicken());
    }

    @Test
    void birthEgg() {
        when(iBirthRepository.birthEgg()).thenReturn(Arrays.asList(birth));
        assertNotNull(birthService.birthEgg());
    }
}