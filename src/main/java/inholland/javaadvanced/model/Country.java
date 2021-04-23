package inholland.javaadvanced.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Country {
    @Id
    private Integer uuid;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="country", fetch = FetchType.EAGER)
    private Set<Beverage> beverages = new HashSet<>();

    public Country() {
    }

    public Country(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Integer getUuid() {
        return uuid;
    }

    public Set<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(Beverage beverage) {
        this.beverages.add(beverage);
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("uuid=").append(uuid);
        sb.append(", name='").append(name).append('\'');
        sb.append(", beverages=").append(beverages);
        sb.append('}');
        return sb.toString();
    }
}
