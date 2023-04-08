package Gisela.demo.service;

import Gisela.demo.repository.iCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CashService {
    @Autowired
    private iCashRepository iCashRepository;

    public Integer showCash() {
        return iCashRepository.showCash();
    }
}
