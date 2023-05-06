package Gisela.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import Gisela.demo.model.Transactions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class ParametersService {

    private Properties properties;
    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("product.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Could not load configuration file: product.properties", e);
        }
        if(entityManager == null) {
            throw new IllegalStateException("EntityManager has not been injected");
        }
    }


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
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("chickenbought"));
    }

    public Integer productIdNewChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("chickennew"));
    }

    public Integer productIdSoldChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("chickensold"));
    }

    public Integer productIdDropChicken() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("chickendrop"));
    }

    public Integer productIdEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("eggbought"));
    }

    public Integer productIdNewEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("eggnew"));
    }

    public Integer productIdSoldEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("eggsold"));
    }

    public Integer productIdDropEgg() {
        return getSingleResultByLike(Transactions.class, Integer.class, properties.getProperty("productid"), properties.getProperty("productnm"), properties.getProperty("eggdrop"));
    }

}
