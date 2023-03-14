package Gisela.demo.repository;

import Gisela.demo.model.ProductsAmt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iProductsRepository extends JpaRepository<ProductsAmt, Integer> {
    @Query(value = "SELECT pb.productamt - ps.productamt - dp.productamt as totalchickens\n" +
            "    FROM buyproducts pb \n" +
            "    INNER JOIN sellproducts ps \n" +
            "    ON pb.operationid = ps.operationid \n" +
            "    INNER JOIN deleteproducts dp\n" +
            "    ON pb.operationid = dp.operationid\n" +
            "    WHERE pb.productid = 1 ", nativeQuery = true)
    List<ProductsAmt> showChickens();

}
