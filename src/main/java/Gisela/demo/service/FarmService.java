package Gisela.demo.service;
import Gisela.demo.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
@Service
public class FarmService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ParametersService parametersService;

    public List<Object[]> getProducts(Integer[] productIds) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Farm> rootFt = cq.from(Farm.class);
        Join<Farm, Transactions> joinPb = rootFt.join("transactions", JoinType.INNER);

        cq.multiselect(rootFt.get("time"), joinPb.get("productnm"), joinPb.get("productprice"));
        cq.where(joinPb.get("productid").in(Arrays.asList(productIds)));
        cq.orderBy(cb.desc(rootFt.get("time")));

        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> results = query.getResultList();

        return results;
    }

    public List<Object[]> buyProducts() {
        Integer chickenProductId = parametersService.productIdChicken();
        Integer eggProductId = parametersService.productIdEgg();
        return getProducts(new Integer[]{chickenProductId, eggProductId});
    }

    public List<Object[]> sellProducts() {
        Integer chickenSoldProductId = parametersService.productIdSoldChicken();
        Integer eggSoldProductId = parametersService.productIdSoldEgg();
        return getProducts(new Integer[]{chickenSoldProductId, eggSoldProductId});
    }

    public List<Object[]> dropProducts() {
        Integer chickenDropProductId = parametersService.productIdDropChicken();
        Integer eggDropProductId = parametersService.productIdDropEgg();
        return getProducts(new Integer[]{chickenDropProductId, eggDropProductId});
    }


}
