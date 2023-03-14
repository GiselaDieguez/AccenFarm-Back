package Gisela.demo.repository;
import Gisela.demo.model.Cash;
import Gisela.demo.model.Validation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface iValidationRepository extends JpaRepository<Validation, Integer>{

    @Query(value = "SELECT pb.productamt - ps.productamt - dp.productamt as totalchickens\n" +
            "    FROM buyproducts pb \n" +
            "    INNER JOIN sellproducts ps \n" +
            "    ON pb.operationid = ps.operationid \n" +
            "    INNER JOIN deleteproducts dp\n" +
            "    ON pb.operationid = dp.operationid\n" +
            "    WHERE pb.productid = 1 ", nativeQuery = true)
    Integer validationAmt();

    @Query(value = "SELECT pb.productamt - ps.productamt - dp.productamt as totaleggs\n" +
            "    FROM buyproducts pb \n" +
            "    INNER JOIN sellproducts ps \n" +
            "    ON pb.operationid = ps.operationid\n" +
            "    INNER JOIN deleteproducts dp\n" +
            "    ON pb.operationid = dp.operationid\n" +
            "    WHERE pb.productid = 2", nativeQuery = true)
    Integer validationAmtEgg();

    @Query(value = "SELECT SUM(totalcash) as totalcash\n" +
            "FROM public.facttransactions", nativeQuery = true)
    Integer validationAmtCash();

}
