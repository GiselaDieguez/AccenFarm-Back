package Gisela.demo.service;

import Gisela.demo.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChickenService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ParametersService parametersService;

    @Transactional
    public void buyChicken() {
        Integer chickenProductId = parametersService.productIdChicken();
        Transactions chicken = entityManager.find(Transactions.class, chickenProductId);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

    @Transactional
    public void sellChicken() {
        Integer chickenSoldProductId = parametersService.productIdSoldChicken();
        Transactions chicken = entityManager.find(Transactions.class, chickenSoldProductId);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

    @Transactional
    public void dropChicken() {
        Integer chickenDropProductId = parametersService.productIdDropChicken();
        Transactions chicken = entityManager.find(Transactions.class, chickenDropProductId);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

}
