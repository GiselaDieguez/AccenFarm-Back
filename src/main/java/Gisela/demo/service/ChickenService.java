package Gisela.demo.service;

import Gisela.demo.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ChickenService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void buyChicken() {
        Buy chicken = entityManager.find(Buy.class, 1L);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

    @Transactional
    public void sellChicken() {
        Sell chicken = entityManager.find(Sell.class, 3L);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

    @Transactional
    public void dropChicken() {
        Delete chicken = entityManager.find(Delete.class, 5L);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

}
