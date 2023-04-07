package Gisela.demo.repository;
import Gisela.demo.model.Buy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iEggAmtRepository extends JpaRepository<Buy, Integer> {
    @Query(value = "SELECT pb.productamt +np.productamt - ps.productamt - dp.productamt as totaleggs\n" +
            "FROM buyproducts pb \n" +
            "INNER JOIN sellproducts ps\n" +
            "ON pb.operationid = ps.operationid\n" +
            "INNER JOIN deleteproducts dp\n" +
            "ON pb.operationid = dp.operationid\n" +
            "INNER JOIN newproducts np\n" +
            "ON pb.operationid = np.operationid \n" +
            "WHERE pb.productid = 2", nativeQuery = true)
    Integer showEggs();
}
