package Gisela.demo.repository;
import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface iValidationRepository extends JpaRepository<Farm, Integer>{

    @Query(value = "SELECT pb.productamt + np.productamt - ps.productamt - dp.productamt as totalchickens\n" +
            "FROM buyproducts pb\n" +
            "INNER JOIN sellproducts ps\n" +
            "ON pb.operationid = ps.operationid\n" +
            "INNER JOIN deleteproducts dp\n" +
            "ON pb.operationid = dp.operationid\n" +
            "INNER JOIN newproducts np\n" +
            "ON pb.operationid = np.operationid \n" +
            "WHERE pb.productid = 1", nativeQuery = true)
    Integer validationAmt();

    @Query(value = "SELECT pb.productamt + np.productamt - ps.productamt - dp.productamt as totaleggs\n" +
            "FROM buyproducts pb \n" +
            "INNER JOIN sellproducts ps \n" +
            "ON pb.operationid = ps.operationid\n" +
            "INNER JOIN deleteproducts dp\n" +
            "ON pb.operationid = dp.operationid\n" +
            "INNER JOIN newproducts np\n" +
            "ON pb.operationid = np.operationid\n" +
            "WHERE pb.productid = 2", nativeQuery = true)
    Integer validationAmtEgg();

    @Query(value = "SELECT SUM(totalcash) as totalcash\n" +
            "FROM public.facttransactions", nativeQuery = true)
    Integer validationAmtCash();

    @Query(value = "SELECT productprice\n" +
            "FROM buyproducts \n" +
            "WHERE productid = 1 ", nativeQuery = true)
    Integer validationChickenPrice();

    @Query(value = "SELECT productprice\n" +
            "FROM buyproducts \n" +
            "WHERE productid = 2 ", nativeQuery = true)
    Integer validationEggPrice();


}
