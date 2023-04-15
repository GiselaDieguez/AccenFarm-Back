package Gisela.demo.service;
import Gisela.demo.model.Transactions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EggService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void buyEggs() {
        Transactions egg = entityManager.find(Transactions.class, 2L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }

    @Transactional
    public void sellEggs() {
        Transactions egg = entityManager.find(Transactions.class, 4L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }

    @Transactional
    public void dropEggs() {
        Transactions egg = entityManager.find(Transactions.class, 6L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }


}
