package inholland.javaadvanced.service;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.repository.IBeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Beverage> getBeverages(){
        return (List<Beverage>) beverageRepo.findAll();
    }

    public Beverage getBeverage(Integer id){
        return beverageRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Beverage updateBeverage(Integer id, String newName) {
        Beverage beverage = getBeverage(id);

        beverage.setName(newName);

        return beverage;
    }

    public boolean deleteBeverage(Integer id) {
        return beverages.removeIf(b -> b.getUuid().equals(id));
    }
}
