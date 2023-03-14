package Gisela.demo.controller;
import Gisela.demo.model.Farm;
import Gisela.demo.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/farm")
public class farmController {
    @Autowired
    private FarmService farmService;

    @GetMapping(value = "/list/buy")
    public ResponseEntity<List<Farm>> buyProducts() {
        farmService.buyProducts();
        return ResponseEntity.status(HttpStatus.OK).body(farmService.buyProducts());
    }

    @GetMapping(value = "/list/sell")
    public ResponseEntity<List<Farm>> sellProducts() {
        farmService.sellProducts();
        return ResponseEntity.status(HttpStatus.OK).body(farmService.sellProducts());
    }

    @GetMapping(value = "/list/drop")
    public ResponseEntity<List<Farm>> dropProducts() {
        farmService.dropProducts();
        return ResponseEntity.status(HttpStatus.OK).body(farmService.dropProducts());
    }

}
