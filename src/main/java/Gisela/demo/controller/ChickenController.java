package Gisela.demo.controller;

import Gisela.demo.service.BirthService;
import Gisela.demo.service.ChickenService;
import Gisela.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Timer;
import java.util.TimerTask;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/chickens")
public class ChickenController {
    @Autowired
    private ChickenService chickenService;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private BirthService birthService;

    @PostMapping("/buy")
    public void buyChicken() {
        Integer validationChicken = validationService.getTotalChickens(1);
        Integer validationAmtCash = validationService.validationAmtCash();
        Integer validationChickenPrice = validationService.getProductPrice(3);

       if (validationChicken < 10 && validationAmtCash > validationChickenPrice && validationChicken >= 0) {

            Timer timer = new Timer();
            timer.schedule(new EggTask(birthService), 30000);

            chickenService.buyChicken();

            ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

        private class EggTask extends TimerTask {
        private BirthService birthService;

        public EggTask(BirthService birthService) {
            this.birthService = birthService;
        }

        @Override
        public void run() {
            Integer validationChicken = validationService.getTotalChickens(1);
            if(validationChicken > 0 && validationChicken < 10){
                birthService.birthEgg();
            }
        }
    }

    @PostMapping("/sell")
    public void sellChicken() {
        Integer validationChicken = validationService.getTotalChickens(1);
        if(validationChicken > 0) {
            chickenService.sellChicken();
            ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/drop")
    public void dropChicken() {
        Integer validationChicken = validationService.getTotalChickens(1);
        if(validationChicken > 0) {
            chickenService.dropChicken();
            ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
