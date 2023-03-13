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

    public List<Egg> buyEggs() {
        return iEggRepository.buyEggs();
    }

    public Page<Egg> getAllEggs(Integer page, Integer size, Boolean enabledPagination) {
        return iEggRepository.findAll(enabledPagination ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    /*
    public void deleteEggs(Long productid) {
        iEggRepository.deleteById(productid);
    }
     */

}
