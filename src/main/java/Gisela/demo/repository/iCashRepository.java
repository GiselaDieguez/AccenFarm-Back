package Gisela.demo.repository;

import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iCashRepository extends JpaRepository<Farm, Integer> {
}
