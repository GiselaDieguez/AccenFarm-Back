package Gisela.demo.controller;
import Gisela.demo.service.BirthService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value= "/birth")

public class birthController {
    @Autowired
    private BirthService BirthService;

    @PostMapping(value = "/chicken")
    public void birthChicken() {
        BirthService.birthChicken();
    }
    @PostMapping(value = "/egg")
    public void birthEgg() {
        BirthService.birthEgg();
    }

}
