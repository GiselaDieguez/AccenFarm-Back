package Gisela.demo.service;

import Gisela.demo.model.ProductsAmt;
import Gisela.demo.repository.iProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private iProductsRepository iProductsRepository;
    public List<ProductsAmt> showChickens() {
        return iProductsRepository.showChickens();

    }

}
