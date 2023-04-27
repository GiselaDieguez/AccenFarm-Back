package Gisela.demo.service;

import Gisela.demo.model.Transactions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BirthService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ParametersService parametersService;

    @Transactional
    public void birthChicken() {
        Integer chickenNewProductId = parametersService.productIdNewChicken();
        Transactions chicken = entityManager.find(Transactions.class, chickenNewProductId);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

    @Transactional
    public void birthEgg() {
        Integer EggNewProductId = parametersService.productIdNewEgg();
        Transactions egg = entityManager.find(Transactions.class, EggNewProductId);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }


}
