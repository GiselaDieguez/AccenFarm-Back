package Gisela.demo.service;

import Gisela.demo.model.Transactions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BirthServiceTest {
    private int count = 100;
    @Autowired
    private BirthService birthService;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testBirthChicken() {
        int productid = ++count;
        Transactions chicken = new Transactions();
        chicken.setProductid(productid);
        chicken.setProductamt(1);
        entityManager.persist(chicken);

        birthService.birthChicken();

        TypedQuery<Integer> query = entityManager.createQuery("SELECT b.productamt FROM Transactions b WHERE b.productid = :productid", Integer.class);
        query.setParameter("productid", productid);
        Integer productamt = query.getSingleResult();
        assertEquals(1, productamt);
    }

    @Test
    @Transactional
    public void testBirthEgg() {
        int productid = ++count;
        Transactions egg = new Transactions();
        egg.setProductid(productid);
        egg.setProductamt(1);
        entityManager.persist(egg);

        birthService.birthEgg();

        TypedQuery<Integer> query = entityManager.createQuery("SELECT b.productamt FROM Transactions b WHERE b.productid = :productid", Integer.class);
        query.setParameter("productid", productid);
        Integer productamt = query.getSingleResult();
        assertEquals(1, productamt);
    }
}
