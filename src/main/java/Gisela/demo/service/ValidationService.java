package Gisela.demo.service;
import Gisela.demo.model.Transactions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidationService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CashService cashService;

    public Integer getTotalChickens(Integer operationId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);

        Root<Transactions> root = cq.from(Transactions.class);

        Expression<Integer> sum1 = cb.sum(
                cb.<Integer>selectCase()
                        .when(cb.or(cb.equal(root.get("productid"), 1), cb.equal(root.get("productid"), 7)), root.get("productamt"))
                        .otherwise(0)
        );

        Expression<Integer> sum2 = cb.sum(
                cb.<Integer>selectCase()
                        .when(cb.or(cb.equal(root.get("productid"), 3), cb.equal(root.get("productid"), 5)), root.get("productamt"))
                        .otherwise(0)
        );

        cq.select(cb.diff(sum1, sum2))
                .where(cb.equal(root.get("operationid"), operationId));

        TypedQuery<Integer> query = entityManager.createQuery(cq);
        Integer result = query.getSingleResult();

        return result;

    }

    public Integer getTotalEggs(Integer operationId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);

        Root<Transactions> root = cq.from(Transactions.class);

        Expression<Integer> sum1 = cb.sum(
                cb.<Integer>selectCase()
                        .when(cb.or(cb.equal(root.get("productid"), 2), cb.equal(root.get("productid"), 8)), root.get("productamt"))
                        .otherwise(0)
        );

        Expression<Integer> sum2 = cb.sum(
                cb.<Integer>selectCase()
                        .when(cb.or(cb.equal(root.get("productid"), 4), cb.equal(root.get("productid"), 6)), root.get("productamt"))
                        .otherwise(0)
        );

        cq.select(cb.diff(sum1, sum2))
                .where(cb.equal(root.get("operationid"), operationId));

        TypedQuery<Integer> query = entityManager.createQuery(cq);
        Integer result = query.getSingleResult();

        return result;

    }

    public Integer getProductPrice(Integer operationId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);

        Root<Transactions> root = criteriaQuery.from(Transactions.class);
        criteriaQuery.select(root.get("productprice"));

        Predicate predicate = criteriaBuilder.equal(root.get("productid"), operationId);
        criteriaQuery.where(predicate);

        TypedQuery<Integer> query = entityManager.createQuery(criteriaQuery);

        Integer productPrice = query.getSingleResult();

        return productPrice;
    }

    public Integer validationAmtCash() {
        return cashService.showCash();
    }


}
