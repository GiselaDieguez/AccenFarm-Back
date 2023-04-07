package Gisela.demo.repository;

import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iCashRepository extends JpaRepository<Farm, Integer> {
    @Query(value = "SELECT SUM(totalcash) as totalcash\n" +
            "FROM public.facttransactions", nativeQuery = true)
    Integer showCash();

}
