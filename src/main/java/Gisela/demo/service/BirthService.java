package Gisela.demo.service;

import Gisela.demo.model.Birth;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class BirthService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void birthChicken() {
        Birth chicken = entityManager.find(Birth.class, 7L);
        chicken.setProductamt(chicken.getProductamt() + 1);
        entityManager.merge(chicken);
    }

    @Transactional
    public void birthEgg() {
        Birth egg = entityManager.find(Birth.class, 8L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }


}
