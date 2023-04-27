package Gisela.demo.controller;
import Gisela.demo.service.ParametersService;
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
    @Autowired
    private ParametersService parametersService;

    @GetMapping(value = "/validation/stockChicken")
    public ResponseEntity<Integer> getTotalChickens() {
        Integer chickenProductId = parametersService.productIdChicken();
        ValidationService.getTotalChickens(chickenProductId);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getTotalChickens(chickenProductId));
    }

    @GetMapping(value = "/validation/stockEgg")
    public ResponseEntity<Integer> getTotalEggs() {
        Integer EggProductId = parametersService.productIdEgg();
        ValidationService.getTotalEggs(EggProductId);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getTotalEggs(EggProductId));
    }

    @GetMapping(value = "/validation/chickenPrice")
    public ResponseEntity<Integer> getProductPrice() {
        Integer chickenSoldProductId = parametersService.productIdSoldChicken();
        ValidationService.getProductPrice(chickenSoldProductId);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getProductPrice(chickenSoldProductId));
    }

    @GetMapping(value = "/validation/eggPrice")
    public ResponseEntity<Integer> validationEggPrice() {
        Integer EggSoldProductId = parametersService.productIdSoldEgg();
        ValidationService.getProductPrice(EggSoldProductId);
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.getProductPrice(EggSoldProductId));
    }

    @GetMapping(value = "/validation/cash")
    public ResponseEntity<Integer> validationAmtCash(){
        ValidationService.validationAmtCash();
        return ResponseEntity.status(HttpStatus.OK).body(ValidationService.validationAmtCash());
    }

}
