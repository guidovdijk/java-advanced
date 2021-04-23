package inholland.javaadvanced.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Beverage {
    @Id
    private Integer uuid;

    @ManyToOne
    private Country country;

    private String name;
    private Double alcoholPercentage;
    private Double cost;

    public Beverage() {
    }

    public Beverage(Integer id, String name, Double alcoholPercentage, Double cost, Country country) {
        this.uuid = id;
        this.name = name;
        this.alcoholPercentage = alcoholPercentage;
        this.cost = cost;
        this.country = country;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Beverage{");
        sb.append("uuid=").append(uuid);
        sb.append(", name='").append(name).append('\'');
        sb.append(", alcoholPercentage=").append(alcoholPercentage);
        sb.append(", cost=").append(cost);
        sb.append('}');
        return sb.toString();
    }
}
