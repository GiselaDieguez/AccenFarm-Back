package Gisela.demo.service;
import Gisela.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iFarmRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class FarmService {

    @Autowired
    private iFarmRepository iFarmRepository;

    public List<Farm> buyProducts() {
        List<Object[]> results = iFarmRepository.buyProducts();
        List<Farm> farms = new ArrayList<>();

        for (Object[] row : results) {
            Farm farm = new Farm();
            farm.setTime((Timestamp) row[0]);
            farm.setProductnm((String) row[1]);
            farm.setProductprice((Integer) row[2]);
            farm.setTransactionamt((Integer) row[3]);
            farms.add(farm);
        }

        return farms;

    }

    public List<Farm> sellProducts() {
        List<Object[]> results = iFarmRepository.sellProducts();
        List<Farm> farms = new ArrayList<>();

        for (Object[] row : results) {
            Farm farm = new Farm();
            farm.setTime((Timestamp) row[0]);
            farm.setProductnm((String) row[1]);
            farm.setProductprice((Integer) row[2]);
            farm.setTransactionamt((Integer) row[3]);
            farms.add(farm);
        }

        return farms;
    }

    public List<Farm> dropProducts() {
        List<Object[]> results = iFarmRepository.dropProducts();
        List<Farm> farms = new ArrayList<>();

        for (Object[] row : results) {
            Farm farm = new Farm();
            farm.setTime((Timestamp) row[0]);
            farm.setProductnm((String) row[1]);
            farm.setProductprice((Integer) row[2]);
            farm.setTransactionamt((Integer) row[3]);
            farms.add(farm);
        }

        return farms;

    }

}
