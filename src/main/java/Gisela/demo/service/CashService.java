package Gisela.demo.service;

import Gisela.demo.model.Cash;
import Gisela.demo.repository.iCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashService {
    @Autowired
    private iCashRepository iCashRepository;

    public List<Cash> showCash() {
        return iCashRepository.showCash();
    }
}
