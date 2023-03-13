package Gisela.demo.repository;
import Gisela.demo.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iEggRepository extends JpaRepository<Egg, Long> {

    @Query(value = "UPDATE public.factproducts \n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 1\n" +
            ";", nativeQuery = true)
    List<Egg> buyEggs();
}
