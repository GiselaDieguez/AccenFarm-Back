package Gisela.demo.service;
import Gisela.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iFarmRepository;

import java.util.List;
@Service
public class FarmService {

    @Autowired
    private iFarmRepository iFarmRepository;

    public List<Farm> buyProducts() {
        return iFarmRepository.buyProducts();

    }

    public List<Farm> sellProducts() {
        return iFarmRepository.sellProducts();

    }

    public List<Farm> dropProducts() {
        return iFarmRepository.dropProducts();

    }

}
