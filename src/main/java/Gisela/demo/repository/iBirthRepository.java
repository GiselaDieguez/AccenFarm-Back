package Gisela.demo.repository;
import Gisela.demo.model.Birth;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface iBirthRepository extends JpaRepository<Birth, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,
            value = "UPDATE newproducts\n" +
            "SET productamt = productamt + 1\n" +
            "WHERE productid = 7")
    void birthChicken();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE newproducts\n" +
            "SET productamt = productamt + 1\n" +
            "WHERE productid = 8", nativeQuery = true)
    void birthEgg();

}
