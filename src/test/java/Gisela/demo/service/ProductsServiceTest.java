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
        // Define el valor esperado
        int expected = 10;

        // Configura el comportamiento del mock
        when(iProductsRepositoryMock.showChickens()).thenReturn(expected);

        // Ejecuta el método que se está probando
        int actual = productsService.showChickens();

        // Comprueba que el valor retornado por el servicio sea el esperado
        assertEquals(expected, actual);
    }
}