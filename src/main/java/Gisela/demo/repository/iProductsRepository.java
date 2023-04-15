package Gisela.demo.repository;

import Gisela.demo.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iProductsRepository extends JpaRepository<Transactions, Integer> {
    @Query(value = "SELECT \n" +
            "SUM(CASE WHEN productid = 1 OR productid = 7 THEN productamt ELSE 0 END) - \n" +
            "SUM(CASE WHEN productid = 3 OR productid = 5 THEN productamt ELSE 0 END) AS totalchickens\n" +
            "FROM dimtrasactiontype\n" +
            "WHERE operationid = 1;", nativeQuery = true)
    Integer showChickens();

}
