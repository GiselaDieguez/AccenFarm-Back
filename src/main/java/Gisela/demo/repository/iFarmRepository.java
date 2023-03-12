package Gisela.demo.repository;
import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iFarmRepository extends JpaRepository<Farm, Long> {
}
