package Gisela.demo.service;
import Gisela.demo.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iFarmRepository;
import java.util.Arrays;
import java.util.List;
@Service
public class FarmService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private iFarmRepository iFarmRepository;


    public List<Object[]> buyProducts() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Farm> rootFt = cq.from(Farm.class);
        Join<Farm, Transactions> joinPb = rootFt.join("transactions", JoinType.INNER);

        cq.multiselect(rootFt.get("time"), joinPb.get("productnm"), joinPb.get("productprice"));
        cq.where(joinPb.get("productid").in(Arrays.asList(1, 2)));
        cq.orderBy(cb.desc(rootFt.get("time")));

        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> results = query.getResultList();

        return results;
    }



    public List<Object[]> sellProducts() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Farm> rootFt = cq.from(Farm.class);
        Join<Farm, Transactions> joinPb = rootFt.join("transactions", JoinType.INNER);

        cq.multiselect(rootFt.get("time"), joinPb.get("productnm"), joinPb.get("productprice"));
        cq.where(joinPb.get("productid").in(Arrays.asList(3, 4)));
        cq.orderBy(cb.desc(rootFt.get("time")));

        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> results = query.getResultList();

        return results;
    }

    public List<Object[]> dropProducts() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Farm> rootFt = cq.from(Farm.class);
        Join<Farm, Transactions> joinPb = rootFt.join("transactions", JoinType.INNER);

        cq.multiselect(rootFt.get("time"), joinPb.get("productnm"));
        cq.where(joinPb.get("productid").in(Arrays.asList(5, 6)));
        cq.orderBy(cb.desc(rootFt.get("time")));

        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> results = query.getResultList();

        return results;
    }

}
