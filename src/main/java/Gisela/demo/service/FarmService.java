package Gisela.demo.service;
import Gisela.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iFarmRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class FarmService {

    @Autowired
    private iFarmRepository iFarmRepository;


    public List<Farm> buyProducts() {
        List<Farm> buy = new ArrayList<>();

        List<Object[]> results = iFarmRepository.buyProducts();

        for (Object[] row : results) {
            Farm farm = new Farm();
            farm.setTime((Timestamp) row[0]);
            farm.setProductnm((String) row[1]);
            farm.setProductprice((Integer) row[2]);
            buy.add(farm);
        }

        return buy;

    }

    public List<Farm> sellProducts() {
        List<Farm> sell = new ArrayList<>();

        List<Object[]> results = iFarmRepository.sellProducts();

        for (Object[] row : results) {
            Farm farm = new Farm();
            farm.setTime((Timestamp) row[0]);
            farm.setProductnm((String) row[1]);
            farm.setProductprice((Integer) row[2]);
            sell.add(farm);
        }

        return sell;
    }

    public List<Farm> dropProducts() {
        List<Farm> drop = new ArrayList<>();

        List<Object[]> results = iFarmRepository.dropProducts();

        for (Object[] row : results) {
            Farm farm = new Farm();
            farm.setTime((Timestamp) row[0]);
            farm.setProductnm((String) row[1]);
            drop.add(farm);
        }

        return drop;

    }

}
