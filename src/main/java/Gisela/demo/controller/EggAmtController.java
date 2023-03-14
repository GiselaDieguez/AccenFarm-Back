package Gisela.demo.controller;

import Gisela.demo.model.EggAmt;
import Gisela.demo.service.EggAmtService;
import Gisela.demo.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/products")
public class EggAmtController {
    @Autowired
    private EggAmtService EggAmtService;
    @GetMapping(value = "/productsamt/egg")
    public ResponseEntity<List<EggAmt>> showEggs() {
        EggAmtService.showEggs();
        return ResponseEntity.status(HttpStatus.OK).body(EggAmtService.showEggs());
    }
}
