package Gisela.demo.service;
import Gisela.demo.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iEggRepository;

import java.util.List;

@Service
public class EggService {

    @Autowired
    private iEggRepository iEggRepository;

    public List<Egg> buyEggs() {
        return iEggRepository.buyEggs();
    }

    public List<Egg> sellEggs() {
        return iEggRepository.sellEggs();
    }

    public List<Egg> dropEggs() {
        return iEggRepository.dropEggs();
    }


}
