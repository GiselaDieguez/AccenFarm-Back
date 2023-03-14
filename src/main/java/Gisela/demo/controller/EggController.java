package Gisela.demo.controller;

import Gisela.demo.model.Egg;
import Gisela.demo.service.EggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/eggs")
public class EggController {
    @Autowired
    private EggService eggService;

    @PostMapping("/buy")
    public ResponseEntity<List<Egg>> buyEggs() {
        eggService.buyEggs();
        return ResponseEntity.status(HttpStatus.CREATED).body(eggService.buyEggs());
    }

    @PostMapping("/sell")
    public ResponseEntity<List<Egg>> sellEggs() {
        eggService.sellEggs();
        return ResponseEntity.status(HttpStatus.CREATED).body(eggService.sellEggs());
    }

    @PostMapping("/drop")
    public ResponseEntity<List<Egg>> dropEggs() {
        eggService.dropEggs();
        return ResponseEntity.status(HttpStatus.CREATED).body(eggService.dropEggs());
    }


}
