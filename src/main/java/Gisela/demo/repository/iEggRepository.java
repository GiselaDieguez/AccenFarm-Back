package Gisela.demo.repository;
import Gisela.demo.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface iEggRepository extends JpaRepository<Egg, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE public.buyproducts \n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 2\n" +
            ";", nativeQuery = true)
    void buyEggs();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE public.sellproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 4;", nativeQuery = true)
    void sellEggs();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE public.deleteproducts\n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 6;", nativeQuery = true)
    void dropEggs();
}
