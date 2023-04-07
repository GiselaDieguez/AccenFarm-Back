package Gisela.demo.service;
import Gisela.demo.model.Buy;
import Gisela.demo.model.Delete;
import Gisela.demo.model.Sell;
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
        Buy egg = entityManager.find(Buy.class, 2L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }

    @Transactional
    public void sellEggs() {
        Sell egg = entityManager.find(Sell.class, 4L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }

    @Transactional
    public void dropEggs() {
        Delete egg = entityManager.find(Delete.class, 6L);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }


}
