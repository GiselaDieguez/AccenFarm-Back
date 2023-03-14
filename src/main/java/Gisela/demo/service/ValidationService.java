package Gisela.demo.service;
import Gisela.demo.repository.iValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidationService {
    @Autowired
    private iValidationRepository iValidationRepository;
    public Integer validationAmt() {
        return iValidationRepository.validationAmt();
    }

    public Integer validationAmtEgg() {
        return iValidationRepository.validationAmtEgg();
    }

    public Integer validationAmtCash() {
        return iValidationRepository.validationAmtCash();
    }

}
