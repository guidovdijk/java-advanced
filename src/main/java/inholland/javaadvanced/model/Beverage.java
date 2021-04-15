package inholland.javaadvanced.model;

public class Beverage {
    private Integer uuid;
    private String name;
    private Double alcoholPercentage;
    private Double cost;

    public Beverage(Integer id, String name, Double alcoholPercentage, Double cost) {
        this.uuid = id;
        this.name = name;
        this.alcoholPercentage = alcoholPercentage;
        this.cost = cost;
    }

    public Integer getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(Double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
