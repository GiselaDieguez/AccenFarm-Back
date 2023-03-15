package Gisela.demo.controller;

import Gisela.demo.model.Egg;
import Gisela.demo.service.BirthService;
import Gisela.demo.service.EggService;
import Gisela.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/eggs")
public class EggController {
    @Autowired
    private EggService eggService;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private BirthService BirthService;

    @PostMapping("/buy")
    public ResponseEntity<List<Egg>> buyEggs() {
        Integer validationEgg = validationService.validationAmtEgg();
        Integer validationAmtCash = validationService.validationAmtCash();
        Integer validationEggPrice = validationService.validationEggPrice();
        if(validationEgg < 10 && validationAmtCash > validationEggPrice) {
            CompletableFuture.delayedExecutor(600000, TimeUnit.SECONDS).execute(() -> {
                BirthService.birthChicken();
            });
            eggService.buyEggs();
            return ResponseEntity.status(HttpStatus.CREATED).body(eggService.buyEggs());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/sell")
    public ResponseEntity<List<Egg>> sellEggs() {
        Integer validationEgg = validationService.validationAmtEgg();
        if(validationEgg > 0) {
            eggService.sellEggs();
            return ResponseEntity.status(HttpStatus.CREATED).body(eggService.sellEggs());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/drop")
    public ResponseEntity<List<Egg>> dropEggs() {
        Integer validationEgg = validationService.validationAmtEgg();
        if(validationEgg > 0) {
            eggService.dropEggs();
            return ResponseEntity.status(HttpStatus.CREATED).body(eggService.dropEggs());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
