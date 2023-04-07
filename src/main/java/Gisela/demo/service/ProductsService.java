package Gisela.demo.service;

import Gisela.demo.repository.iProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private iProductsRepository iProductsRepository;
    public Integer showChickens() {
        return iProductsRepository.showChickens();

    }

}
