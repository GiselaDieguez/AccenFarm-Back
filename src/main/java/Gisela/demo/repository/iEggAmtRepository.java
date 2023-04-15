package Gisela.demo.repository;
import Gisela.demo.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iEggAmtRepository extends JpaRepository<Transactions, Integer> {
    @Query(value = "SELECT \n" +
            "SUM(CASE WHEN productid = 2 OR productid = 8 THEN productamt ELSE 0 END) - \n" +
            "SUM(CASE WHEN productid = 4 OR productid = 6 THEN productamt ELSE 0 END) AS totaleggs\n" +
            "FROM dimtrasactiontype\n" +
            "WHERE operationid = 2;", nativeQuery = true)
    Integer showEggs();
}
