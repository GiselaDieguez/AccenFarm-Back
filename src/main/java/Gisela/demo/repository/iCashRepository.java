package Gisela.demo.repository;

import Gisela.demo.model.Cash;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iCashRepository extends JpaRepository<Cash, Long> {
    @Query(value = "SELECT SUM(totalcash) as totalcash\n" +
            "FROM public.facttransactions", nativeQuery = true)
    List<Cash> showCash();

}
