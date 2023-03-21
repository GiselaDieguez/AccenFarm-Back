package Gisela.demo.service;

import Gisela.demo.repository.iBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BirthService {
    @Autowired
    private iBirthRepository iBirthRepository;

    @Autowired
    public void setiBirthRepository(iBirthRepository iBirthRepository) {
        this.iBirthRepository = iBirthRepository;
    }

    public void birthChicken() {
         iBirthRepository.birthChicken();
    }

    public void birthEgg() {
         iBirthRepository.birthEgg();
    }


}
