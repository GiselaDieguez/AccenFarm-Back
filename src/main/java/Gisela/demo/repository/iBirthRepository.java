package Gisela.demo.repository;
import Gisela.demo.model.Birth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface iBirthRepository extends JpaRepository<Birth, Long> {
    @Query(value = "UPDATE newproducts\n" +
            "SET productamt = productamt + 1\n" +
            "WHERE productid = 7", nativeQuery = true)
    List<Birth> birthChicken();

    @Query(value = "UPDATE newproducts\n" +
            "SET productamt = productamt + 1\n" +
            "WHERE productid = 8", nativeQuery = true)
    List<Birth> birthEgg();

}
