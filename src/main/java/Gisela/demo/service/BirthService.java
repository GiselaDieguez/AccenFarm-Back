package Gisela.demo.service;

import Gisela.demo.model.Birth;
import Gisela.demo.repository.iBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthService {
    @Autowired
    private iBirthRepository iBirthRepository;

    public List<Birth> birthChicken() {

        return iBirthRepository.birthChicken();
    }

    public List<Birth> birthEgg() {
        return iBirthRepository.birthEgg();
    }


}
