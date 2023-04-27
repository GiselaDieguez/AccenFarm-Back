package Gisela.demo.service;
import Gisela.demo.model.Transactions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EggService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ParametersService parametersService;

    @Transactional
    public void buyEggs() {
        Integer EggProductId = parametersService.productIdEgg();
        Transactions egg = entityManager.find(Transactions.class, EggProductId);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }

    @Transactional
    public void sellEggs() {
        Integer EggSoldProductId = parametersService.productIdSoldEgg();
        Transactions egg = entityManager.find(Transactions.class, EggSoldProductId);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }

    @Transactional
    public void dropEggs() {
        Integer EggDropProductId = parametersService.productIdDropEgg();
        Transactions egg = entityManager.find(Transactions.class, EggDropProductId);
        egg.setProductamt(egg.getProductamt() + 1);
        entityManager.merge(egg);
    }


}
