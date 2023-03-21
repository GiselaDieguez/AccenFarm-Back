package Gisela.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iChickenRepository;

@Service
public class ChickenService {
    @Autowired
    private iChickenRepository iChickenRepository;

    @Autowired
    public void setiChickenRepository(iChickenRepository iChickenRepository) {
        this.iChickenRepository = iChickenRepository;
    }

    public void buyChicken() {
        iChickenRepository.buyChicken();
    }
    public void sellChicken() {
        iChickenRepository.sellChicken();
    }
    public void dropChicken() { iChickenRepository.dropChicken(); }

}
