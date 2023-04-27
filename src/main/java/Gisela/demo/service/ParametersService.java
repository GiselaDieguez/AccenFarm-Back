package Gisela.demo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import Gisela.demo.model.Transactions;
import org.springframework.stereotype.Service;

@Service
public class ParametersService {
    @PersistenceContext
    private EntityManager entityManager;

    public <T, R> R getSingleResultByLike(Class<T> entityClass, Class<R> resultClass, String attributeName, String likeAttribute, String likeValue) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<R> query = builder.createQuery(resultClass);
        Root<T> root = query.from(entityClass);
        query.select(root.get(attributeName));
        Predicate condition = builder.like(root.get(likeAttribute), likeValue);
        query.where(condition);
        TypedQuery<R> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    public Integer productIdChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%Bought Chicken%");
    }

    public Integer productIdNewChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%New Chicken%");
    }

    public Integer productIdSoldChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%Sold Chicken%");
    }

    public Integer productIdDropChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%Drop Chicken%");
    }

    public Integer productIdEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%Bought Egg%");
    }

    public Integer productIdNewEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%New Egg%");
    }

    public Integer productIdSoldEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%Sold Egg%");
    }

    public Integer productIdDropEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, "productid", "productnm", "%Drop Egg%");
    }

}
