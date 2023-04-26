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


    @GetMapping(value = "/validation/stockChicken")
    public ResponseEntity<Integer> getTotalChickens() {
        ValidationService.getTotalChickens(1);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getTotalChickens(1));
    }

    @GetMapping(value = "/validation/stockEgg")
    public ResponseEntity<Integer> getTotalEggs() {
        ValidationService.getTotalEggs(2);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getTotalEggs(2));
    }

    @GetMapping(value = "/validation/chickenPrice")
    public ResponseEntity<Integer> getProductPrice() {
        ValidationService.getProductPrice(3);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getProductPrice(3));
    }

    @GetMapping(value = "/validation/eggPrice")
    public ResponseEntity<Integer> validationEggPrice() {
        ValidationService.getProductPrice(4);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getProductPrice(4));
    }

    @GetMapping(value = "/validation/cash")
    public ResponseEntity<Integer> validationAmtCash(){
        ValidationService.validationAmtCash();
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.validationAmtCash());
    }

}
