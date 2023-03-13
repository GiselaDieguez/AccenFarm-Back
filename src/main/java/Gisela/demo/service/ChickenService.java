package Gisela.demo.service;

import Gisela.demo.model.Chicken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iChickenRepository;

import java.util.List;

@Service
public class ChickenService {
    @Autowired
    private iChickenRepository iChickenRepository;

    public List<Chicken> buyChicken() {
        return iChickenRepository.buyChicken();
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
