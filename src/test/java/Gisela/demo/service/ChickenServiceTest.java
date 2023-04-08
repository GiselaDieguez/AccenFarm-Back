package Gisela.demo.service;

import Gisela.demo.model.Buy;
import Gisela.demo.model.Delete;
import Gisela.demo.model.Sell;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChickenServiceTest {

    @Autowired
    private ChickenService chickenService;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {

        Buy buy = new Buy();
        buy.setProductid(1);
        buy.setProductamt(0);
        entityManager.persist(buy);

        Sell sell = new Sell();
        sell.setProductid(3);
        sell.setProductamt(0);
        entityManager.persist(sell);

        Delete delete = new Delete();
        delete.setProductid(5);
        delete.setProductamt(0);
        entityManager.persist(delete);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testBuyChicken() {
        chickenService.buyChicken();

        Buy chicken = entityManager.find(Buy.class, 1L);
        assertEquals(1, chicken.getProductamt());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testSellChicken() {
        chickenService.sellChicken();

        Sell chicken = entityManager.find(Sell.class, 3L);
        assertEquals(1, chicken.getProductamt());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testDropChicken() {
        chickenService.dropChicken();

        Delete chicken = entityManager.find(Delete.class, 5L);
        assertEquals(1, chicken.getProductamt());
    }
}
