package Gisela.demo.service;

import Gisela.demo.model.EggAmt;
import Gisela.demo.repository.iEggAmtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EggAmtService {
    @Autowired
    private iEggAmtRepository iEggAmtRepository;

    public List<EggAmt> showEggs() {
        return iEggAmtRepository.showEggs();

    }
}
