package Gisela.demo.controller;

import Gisela.demo.service.BirthService;
import Gisela.demo.service.EggService;
import Gisela.demo.service.ParametersService;
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
    @Autowired
    private ParametersService parametersService;

    @PostMapping("/buy")
    public void buyEggs() {
        Integer EggProductId = parametersService.productIdEgg();
        Integer EggSoldProductId = parametersService.productIdSoldEgg();
        Integer validationEgg = validationService.getTotalEggs(EggProductId);
        Integer validationAmtCash = validationService.validationAmtCash();
        Integer validationEggPrice = validationService.getProductPrice(EggSoldProductId);
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
            Integer EggProductId = parametersService.productIdEgg();
            Integer validationEgg = validationService.getTotalEggs(EggProductId);
            if(validationEgg > 0 && validationEgg < 10){
                birthService.birthChicken();
            }
        }
    }

    @PostMapping("/sell")
    public void sellEggs() {
        Integer EggProductId = parametersService.productIdEgg();
        Integer validationEgg = validationService.getTotalEggs(EggProductId);
        if(validationEgg > 0) {
            eggService.sellEggs();
            ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/drop")
    public void dropEggs() {
        Integer EggProductId = parametersService.productIdEgg();
        Integer validationEgg = validationService.getTotalEggs(EggProductId);
        if(validationEgg > 0) {
            eggService.dropEggs();
            ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
