package Gisela.demo.service;

import Gisela.demo.model.Transactions;
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

        Transactions buy = new Transactions();
        buy.setProductid(1);
        buy.setProductamt(0);
        entityManager.persist(buy);

        Transactions sell = new Transactions();
        sell.setProductid(3);
        sell.setProductamt(0);
        entityManager.persist(sell);

        Transactions delete = new Transactions();
        delete.setProductid(5);
        delete.setProductamt(0);
        entityManager.persist(delete);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testBuyChicken() {
        chickenService.buyChicken();

        Transactions chicken = entityManager.find(Transactions.class, 1L);
        assertEquals(1, chicken.getProductamt());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testSellChicken() {
        chickenService.sellChicken();

        Transactions chicken = entityManager.find(Transactions.class, 3L);
        assertEquals(1, chicken.getProductamt());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testDropChicken() {
        chickenService.dropChicken();

        Transactions chicken = entityManager.find(Transactions.class, 5L);
        assertEquals(1, chicken.getProductamt());
    }
}
