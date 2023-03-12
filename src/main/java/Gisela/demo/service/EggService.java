package Gisela.demo.service;
import Gisela.demo.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iEggRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EggService {

    @Autowired
    private iEggRepository iEggRepository;

    public Egg buyEggs(Egg egg) {
        if(egg.getProductid() == null) {
            return iEggRepository.save(egg);
        }
        return null;
    }

    public Page<Egg> getAllEggs(Integer page, Integer size, Boolean enabledPagination) {
        return iEggRepository.findAll(enabledPagination ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    // editttt

    public Egg editEgg(Egg egg) {
        if(egg.getProductid() != null && iEggRepository.existsById(egg.getProductid())){
            return iEggRepository.save(egg);
        }
        return null;
    }

    // find farm chickens
    public Optional<Egg> findByProductid(Long productid) {
        return iEggRepository.findByProductid(productid);

    }
    public void deleteEggs(Long productid) {
        iEggRepository.deleteById(productid);
    }

    public boolean existsById(Long productid) {
        return iEggRepository.existsById(productid);
    }
}
