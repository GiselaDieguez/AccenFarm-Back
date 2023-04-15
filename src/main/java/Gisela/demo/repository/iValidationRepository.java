package Gisela.demo.repository;
import Gisela.demo.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface iValidationRepository extends JpaRepository<Transactions, Integer>{

    @Query(value = "SELECT \n" +
            "SUM(CASE WHEN productid = 1 OR productid = 7 THEN productamt ELSE 0 END) - \n" +
            "SUM(CASE WHEN productid = 3 OR productid = 5 THEN productamt ELSE 0 END) AS totalchickens\n" +
            "FROM dimtrasactiontype\n" +
            "WHERE operationid = 1;", nativeQuery = true)
    Integer validationAmt();

    @Query(value = "SELECT \n" +
            "SUM(CASE WHEN productid = 2 OR productid = 8 THEN productamt ELSE 0 END) - \n" +
            "SUM(CASE WHEN productid = 4 OR productid = 6 THEN productamt ELSE 0 END) AS totaleggs\n" +
            "FROM dimtrasactiontype\n" +
            "WHERE operationid = 2;", nativeQuery = true)
    Integer validationAmtEgg();

    @Query(value = "SELECT SUM(totalcash) as totalcash\n" +
            "FROM public.facttransactions", nativeQuery = true)
    Integer validationAmtCash();

    @Query(value = "SELECT productprice\n" +
            "FROM dimtrasactiontype \n" +
            "WHERE productid = 1 ", nativeQuery = true)
    Integer validationChickenPrice();

    @Query(value = "SELECT productprice\n" +
            "FROM dimtrasactiontype \n" +
            "WHERE productid = 2 ", nativeQuery = true)
    Integer validationEggPrice();


}
