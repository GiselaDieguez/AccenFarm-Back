package Gisela.demo.controller;
import Gisela.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping(value = "/validation/chickenPrice")
    public ResponseEntity<Integer> validationChickenPrice() {
        ValidationService.validationChickenPrice();
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.validationChickenPrice());
    }

    @GetMapping(value = "/validation/eggPrice")
    public ResponseEntity<Integer> validationEggPrice() {
        ValidationService.validationEggPrice();
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.validationEggPrice());
    }

}
