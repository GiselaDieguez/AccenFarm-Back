package Gisela.demo.controller;

import Gisela.demo.service.EggAmtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/products")
public class EggAmtController {
    @Autowired
    private EggAmtService EggAmtService;
    @GetMapping(value = "/productsamt/egg")
    public ResponseEntity<Integer> showEggs() {
        EggAmtService.showEggs();
        return ResponseEntity.status(HttpStatus.OK).body(EggAmtService.showEggs());
    }
}
