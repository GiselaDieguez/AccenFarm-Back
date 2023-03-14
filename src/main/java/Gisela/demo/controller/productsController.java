package Gisela.demo.controller;
import Gisela.demo.model.ProductsAmt;
import Gisela.demo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/products")
public class productsController {

    @Autowired
    private ProductsService ProductsService;
    @GetMapping(value = "/productsamt/chicken")
    public ResponseEntity<List<ProductsAmt>> showChickens() {
        ProductsService.showChickens();
        return ResponseEntity.status(HttpStatus.OK).body(ProductsService.showChickens());
    }

}

