package Gisela.demo.controller;

import Gisela.demo.model.Farm;
import Gisela.demo.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/farm")
public class farmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("/all")
    public ResponseEntity<Page<Farm>> getAllData(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enabledPagination) {
        return ResponseEntity.ok(farmService.getAllData(page, size, enabledPagination));
    }

}
