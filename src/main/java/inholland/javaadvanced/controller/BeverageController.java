package inholland.javaadvanced.controller;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(beverageService.getBeverages(), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Beverage> createBeverage(@RequestBody Beverage beverage) {
        Beverage newBeverage = beverageService.addBeverage(beverage);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBeverage);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Beverage> getBeverage(@PathVariable Integer id) {
        HttpStatus status = HttpStatus.OK;

        Beverage beverage =  beverageService.getBeverage(id);

        if (beverage == null) {
            status = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(status).body(beverage);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Beverage> updateBeverage(@PathVariable Integer id, @RequestParam("name") String newName) {
        HttpStatus status = HttpStatus.OK;

        Beverage beverage =  beverageService.updateBeverage(id, newName);

        if (beverage == null) {
            status = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(status).body(beverage);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBeverage(@PathVariable Integer id) {
        HttpStatus status = HttpStatus.OK;
        String body = "Beverage deleted";

        boolean isRemoved =  beverageService.deleteBeverage(id);

        if (!isRemoved) {
            status = HttpStatus.NOT_FOUND;
            body = "Beverage could not be found";
        }

        return ResponseEntity.status(status).body(body);
    }
}
