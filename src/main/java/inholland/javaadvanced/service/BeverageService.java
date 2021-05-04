package inholland.javaadvanced.service;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.repository.IBeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BeverageService {
    private List<Beverage> beverages;

    @Autowired
    private IBeverageRepository beverageRepo;

    public BeverageService() {

    }

    public Beverage addBeverage(Beverage beverage){
        beverageRepo.save(beverage);
        return beverage;
    }

    // Get beverages that has a letter 'm' in it
    public List<Beverage> findSpecificBeverages() {
        return (List<Beverage>) beverageRepo.findSpecificBeverages();
    }

    // Get beverages that has a letter 'm' in it. Same functionality as 'findSpecificBeverages', but with lambda
    public List<Beverage> findSpecificBeveragesHostCalculation(){
        List<Beverage> beverages = (List<Beverage>) beverageRepo.findAll();

        return beverages.stream()
          .filter(b -> b.getName().contains("i"))
          .collect(Collectors.toList());
    }

    public List<Beverage> getBeverages(){
        return (List<Beverage>) beverageRepo.findAll();
    }

    public Beverage getBeverage(Integer id){
        return beverageRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
