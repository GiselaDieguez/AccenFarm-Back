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
public class EggServiceTest {

    @Autowired
    private EggService eggService;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {

        Transactions buy = new Transactions();
        buy.setProductid(2);
        buy.setProductamt(0);
        entityManager.persist(buy);

        Transactions sell = new Transactions();
        sell.setProductid(4);
        sell.setProductamt(0);
        entityManager.persist(sell);

        Transactions delete = new Transactions();
        delete.setProductid(6);
        delete.setProductamt(0);
        entityManager.persist(delete);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testBuyEgg() {
        eggService.buyEggs();

        Transactions Egg = entityManager.find(Transactions.class, 2L);
        assertEquals(1, Egg.getProductamt());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testSellEgg() {
        eggService.sellEggs();

        Transactions Egg = entityManager.find(Transactions.class, 4L);
        assertEquals(1, Egg.getProductamt());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testDropEgg() {
        eggService.dropEggs();

        Transactions Egg = entityManager.find(Transactions.class, 6L);
        assertEquals(1, Egg.getProductamt());
    }
}