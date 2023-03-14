package Gisela.demo.repository;
import Gisela.demo.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iEggRepository extends JpaRepository<Egg, Long> {

    @Query(value = "UPDATE public.buyproducts \n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 2\n" +
            ";", nativeQuery = true)
    List<Egg> buyEggs();

    @Query(value = "UPDATE public.sellproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 4;", nativeQuery = true)
    List<Egg> sellEggs();

    @Query(value = "UPDATE public.deleteproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 6;", nativeQuery = true)
    List<Egg> dropEggs();
}
