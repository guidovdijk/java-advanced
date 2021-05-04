package inholland.javaadvanced.controller;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.service.BeverageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/beverages")

public class BeverageController {

    @Autowired
    private BeverageService beverageService;

    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beverage>> getBeverages() {
        return new ResponseEntity<>(beverageService.findSpecificBeverages(), HttpStatus.OK);
    }


    @GetMapping(value = "/host_calculation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beverage>> getBeveragesHostCalculate() {
        return new ResponseEntity<>(beverageService.findSpecificBeveragesHostCalculation(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Beverage> getBeverage(@PathVariable Integer id) {
        try {
            Beverage beverage =  beverageService.getBeverage(id);

            return new ResponseEntity<Beverage>(beverage, HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
