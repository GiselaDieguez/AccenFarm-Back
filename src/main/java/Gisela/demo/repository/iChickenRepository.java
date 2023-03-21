package Gisela.demo.repository;

import Gisela.demo.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface iChickenRepository extends JpaRepository<Chicken, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE public.buyproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 1\n" +
            ";", nativeQuery = true)
    void buyChicken();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE public.sellproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 3\n" +
            ";", nativeQuery = true)
    void sellChicken();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE public.deleteproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 5;", nativeQuery = true)
    void dropChicken();


}
