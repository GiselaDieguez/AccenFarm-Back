package Gisela.demo.repository;
import Gisela.demo.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iEggRepository extends JpaRepository<Egg, Long> {
    Optional<Egg> findByProductid(Long productid);
}
