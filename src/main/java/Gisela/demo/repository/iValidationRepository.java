package Gisela.demo.repository;
import Gisela.demo.model.Transactions;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface iValidationRepository extends JpaRepository<Transactions, Integer>{
}
