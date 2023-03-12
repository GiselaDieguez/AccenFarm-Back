package Gisela.demo.repository;

import Gisela.demo.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iChickenRepository extends JpaRepository<Chicken, Long> {
    List<Chicken> findByActiveind(Long activeind);
}
