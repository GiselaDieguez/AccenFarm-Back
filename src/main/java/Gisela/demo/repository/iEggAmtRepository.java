package Gisela.demo.repository;
import Gisela.demo.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iEggAmtRepository extends JpaRepository<Transactions, Integer> {
}
