package Gisela.demo.controller;
import Gisela.demo.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/cash")
public class cashController {
    @Autowired
    private CashService CashService;

    @GetMapping(value = "/all")
    public ResponseEntity<Integer> showCash() {
        CashService.showCash();
        return ResponseEntity.status(HttpStatus.OK).body(CashService.showCash());
    }

}
