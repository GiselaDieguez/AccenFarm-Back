package Gisela.demo.service;

import Gisela.demo.repository.iEggAmtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EggAmtService {
    @Autowired
    private iEggAmtRepository iEggAmtRepository;

    public Integer showEggs() {
        return iEggAmtRepository.showEggs();

    }
}
