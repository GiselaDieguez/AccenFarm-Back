package Gisela.demo.controller;

import Gisela.demo.service.BirthService;
import Gisela.demo.service.EggService;
import Gisela.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Timer;
import java.util.TimerTask;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/eggs")
public class EggController {
    @Autowired
    private EggService eggService;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private BirthService birthService;

    @PostMapping("/buy")
    public void buyEggs() {
        Integer validationEgg = validationService.validationAmtEgg();
        Integer validationAmtCash = validationService.validationAmtCash();
        Integer validationEggPrice = validationService.validationEggPrice();
        if (validationEgg < 10 && validationAmtCash > validationEggPrice && validationEgg >= 0 ) {

            Timer t = new Timer();
            t.schedule(new ChickenTask(birthService), 45000);

            eggService.buyEggs();

            ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

        private class ChickenTask extends TimerTask {
        private BirthService birthService;

        public ChickenTask(BirthService birthService) {
            this.birthService = birthService;
        }

        @Override
        public void run() {
            Integer validationEgg = validationService.validationAmtEgg();
            if(validationEgg > 0 && validationEgg < 10){
                birthService.birthChicken();
            }
        }
    }

    @PostMapping("/sell")
    public void sellEggs() {
        Integer validationEgg = validationService.validationAmtEgg();
        if(validationEgg > 0) {
            eggService.sellEggs();
            ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/drop")
    public void dropEggs() {
        Integer validationEgg = validationService.validationAmtEgg();
        if(validationEgg > 0) {
            eggService.dropEggs();
            ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
