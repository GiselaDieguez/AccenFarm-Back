package Gisela.demo.repository;

import Gisela.demo.model.Chicken;
import Gisela.demo.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iChickenRepository extends JpaRepository<Chicken, Long> {

    @Query(value = "UPDATE public.buyproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 1\n" +
            ";", nativeQuery = true)
    List<Chicken> buyChicken();

    @Query(value = "UPDATE public.sellproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 3\n" +
            ";", nativeQuery = true)
    List<Chicken> sellChicken();

    @Query(value = "UPDATE public.deleteproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 5;", nativeQuery = true)
    List<Chicken> dropChicken();


}
