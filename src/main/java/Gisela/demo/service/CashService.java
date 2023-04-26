package Gisela.demo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import Gisela.demo.model.Farm;


@Service
public class CashService {

    @PersistenceContext
    private EntityManager entityManager;

    public Integer showCash() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);

        Root<Farm> root = criteriaQuery.from(Farm.class);
        criteriaQuery.select(criteriaBuilder.sum(root.get("totalcash")));

        TypedQuery<Integer> query = entityManager.createQuery(criteriaQuery);

        Integer totalCash = query.getSingleResult();

        return totalCash;
    }


}
