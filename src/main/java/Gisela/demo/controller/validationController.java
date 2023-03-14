package Gisela.demo.controller;
import Gisela.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/farm")
public class validationController {
    @Autowired
    private ValidationService ValidationService;
    @GetMapping(value = "/validation/stock")
    public ResponseEntity<Integer> validationAmt() {
        ValidationService.validationAmt();
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.validationAmt());
    }

    @GetMapping(value = "/validation/stockEgg")
    public ResponseEntity<Integer> validationAmtEgg() {
        ValidationService.validationAmtEgg();
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.validationAmtEgg());
    }

}