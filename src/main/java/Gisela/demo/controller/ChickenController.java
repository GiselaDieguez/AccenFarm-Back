package Gisela.demo.controller;

import Gisela.demo.model.Chicken;
import Gisela.demo.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/chickens")
public class ChickenController {
    @Autowired
    private ChickenService chickenService;

    @PostMapping("/chicken")
    public ResponseEntity<List<Chicken>> buyChicken() {
        chickenService.buyChicken();
        return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.buyChicken());
    }

}
