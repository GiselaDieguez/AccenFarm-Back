package Gisela.demo.controller;

import Gisela.demo.model.Chicken;
import Gisela.demo.service.ChickenService;
import Gisela.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/chickens")
public class ChickenController {
    @Autowired
    private ChickenService chickenService;
    @Autowired
    private ValidationService validationService;
    @PostMapping("/buy")
    public ResponseEntity<List<Chicken>> buyChicken() {
        Integer validationChicken = validationService.validationAmt();
        Integer validationAmtCash = validationService.validationAmtCash();
        if (validationChicken < 10 && validationAmtCash > 200) {
            chickenService.buyChicken();
            return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.buyChicken());
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/sell")
    public ResponseEntity<List<Chicken>> sellChicken() {
        Integer validationChicken = validationService.validationAmt();
        if(validationChicken > 0) {
            chickenService.sellChicken();
            return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.sellChicken());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/drop")
    public ResponseEntity<List<Chicken>> dropChicken() {
        Integer validationChicken = validationService.validationAmt();
        if(validationChicken > 0) {
            chickenService.dropChicken();
            return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.dropChicken());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
