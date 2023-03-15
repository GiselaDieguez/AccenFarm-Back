package Gisela.demo.controller;
import Gisela.demo.model.Birth;
import Gisela.demo.model.Egg;
import Gisela.demo.service.BirthService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/birth")

public class birthController {
    @Autowired
    private BirthService BirthService;

    @GetMapping(value = "/chicken")
    public ResponseEntity<List<Birth>> birthChicken() {
        BirthService.birthChicken();
        return ResponseEntity.status(HttpStatus.OK).body(BirthService.birthChicken());
    }
    @GetMapping(value = "/egg")
    public ResponseEntity<List<Birth>> birthEgg() {
        BirthService.birthEgg();
        return ResponseEntity.status(HttpStatus.OK).body(BirthService.birthEgg());
    }

}
