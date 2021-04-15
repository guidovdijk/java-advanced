package inholland.javaadvanced.service;

import inholland.javaadvanced.model.Beverage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeverageService {
    private List<Beverage> beverages;

    public BeverageService() {
        this.beverages = new ArrayList<>(
                List.of(
                        new Beverage(1, "Bacardi", 40.0, 42.50),
                        new Beverage(2, "Wodka", 45.5, 21.00),
                        new Beverage(3, "Captain Morgan", 34.0, 39.99)
                )
        );
    }

    public Beverage addBeverage(Beverage beverage){
        beverages.add(beverage);
        return beverage;
    }

    public List<Beverage> getBeverages(){
        return beverages;
    }

    public Beverage getBeverage(Integer id){
        return beverages.stream()
                .filter(b -> id.equals(b.getUuid()))
                .findFirst()
                .orElse(null);
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
