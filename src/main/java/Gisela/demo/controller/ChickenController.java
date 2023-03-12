package Gisela.demo.controller;

import Gisela.demo.model.Chicken;
import Gisela.demo.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/chickens", method = RequestMethod.GET, produces = "application/json")
public class ChickenController {
    @Autowired
    private ChickenService chickenService;

    @PostMapping("/buyChicken")
    public ResponseEntity<Chicken> buyChicken (@RequestBody Chicken chicken) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.buyChicken(chicken));
    }

    @GetMapping("/allChickens")
    public ResponseEntity<Page<Chicken>> getAllChickens(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enabledPagination) {
        return ResponseEntity.ok(chickenService.getAllChickens(page, size, enabledPagination));
    }

    @GetMapping(value = "/{activeind}")
    public ResponseEntity<List<Chicken>> findChickenByFarm(@PathVariable ("activeind") Long activeind) {
        chickenService.findByActiveind(activeind);
        return ResponseEntity.status(HttpStatus.OK).body(chickenService.findByActiveind(activeind));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteChicken(@PathVariable ("id") Long id) {
        chickenService.deleteChicken(id);
        return ResponseEntity.ok(!chickenService.existsById(id));
    }
}
