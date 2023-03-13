package Gisela.demo.repository;

import Gisela.demo.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iChickenRepository extends JpaRepository<Chicken, Long> {

    @Query(value = "SELECT * FROM chicken WHERE activeind =?1", nativeQuery = true)
    List<Chicken> findByActiveind(Long activeind);


    @Query(value = "UPDATE public.factproducts \n" +
            "SET productamt = productamt + 1 \n" +
            "WHERE productid = 5\n" +
            ";", nativeQuery = true)
    List<Chicken> buyChicken();



}
