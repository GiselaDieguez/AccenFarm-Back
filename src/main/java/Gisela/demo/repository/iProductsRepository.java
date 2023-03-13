package Gisela.demo.repository;

import Gisela.demo.model.ProductsAmt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iProductsRepository extends JpaRepository<ProductsAmt, Integer> {
    @Query(value = "SELECT productamt\n" +
            "FROM public.factProducts \n" +
            "WHERE productid IN (1, 5)", nativeQuery = true)
    List<ProductsAmt> showProductAmt();

}
