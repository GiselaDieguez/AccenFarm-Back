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
    public List<Chicken> sellChicken() {
        return iChickenRepository.sellChicken();
    }
    public List<Chicken> dropChicken() { return iChickenRepository.dropChicken(); }

}
