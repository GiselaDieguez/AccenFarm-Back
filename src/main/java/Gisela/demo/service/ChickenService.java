package Gisela.demo.service;

import Gisela.demo.model.Chicken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iChickenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChickenService {
    @Autowired
    private iChickenRepository iChickenRepository;

    public Chicken buyChicken(Chicken chicken) {
        return iChickenRepository.save(chicken);
    }

    public Page<Chicken> getAllChickens(Integer page, Integer size, Boolean enabledPagination) {
        return iChickenRepository.findAll(enabledPagination ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    // find  buy chickens


    // find farm chickens
    public List<Chicken> findByActiveind(Long activeind) {
        return iChickenRepository.findByActiveind(activeind);

    }
    public void deleteChicken(Long id) {
        iChickenRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iChickenRepository.existsById(id);
    }
}
