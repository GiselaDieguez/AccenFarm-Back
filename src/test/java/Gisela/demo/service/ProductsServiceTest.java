package Gisela.demo.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import Gisela.demo.repository.iProductsRepository;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductsServiceTest {
    @Mock
    private iProductsRepository iProductsRepositoryMock;

    @InjectMocks
    private ProductsService productsService;

    @Test
    public void testShowChickens() {
        int expected = 8;
        when(iProductsRepositoryMock.showChickens()).thenReturn(expected);
        int actual = productsService.showChickens();
        assertEquals(expected, actual);
    }
}