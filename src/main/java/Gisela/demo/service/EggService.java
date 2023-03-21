package Gisela.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iEggRepository;

@Service
public class EggService {

    @Autowired
    private iEggRepository iEggRepository;

    @Autowired
    public void setiEggRepository(iEggRepository iEggRepository) {
        this.iEggRepository = iEggRepository;
    }

    public void buyEggs() {
        iEggRepository.buyEggs();
    }

    public void sellEggs() {
        iEggRepository.sellEggs();
    }

    public void dropEggs() {
        iEggRepository.dropEggs();
    }


}
