package Gisela.demo.controller;

import Gisela.demo.model.Egg;
import Gisela.demo.service.EggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value= "/eggs")
public class EggController {
    @Autowired
    private EggService eggService;

    @PostMapping("/buyeggs")
    public ResponseEntity<List<Egg>> buyEggs() {
        eggService.buyEggs();
        return ResponseEntity.status(HttpStatus.CREATED).body(eggService.buyEggs());
    }

    @GetMapping("/allEggs")
    public ResponseEntity<Page<Egg>> findAllEggs(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enabledPagination) {
        return ResponseEntity.ok(eggService.getAllEggs(page, size, enabledPagination));
    }

    /*
    @DeleteMapping(value = "/delete/{productid}")
    public ResponseEntity deleteEggs(@PathVariable ("productid") Long productid) {
        eggService.deleteEggs(productid);
        return ResponseEntity.ok(!eggService.existsById(productid));
    }
    */
}
