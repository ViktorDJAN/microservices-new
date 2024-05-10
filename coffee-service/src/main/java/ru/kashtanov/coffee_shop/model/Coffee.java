package ru.kashtanov.coffee_shop.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Coffee {
    @Id
    @Column(name = "coffee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coffeeId;
    private String coffeeName;
    private Double weight;

    public Coffee() {
    }
    public Coffee(String coffeeName,Double weight){
        this.coffeeName = coffeeName;
        this.weight = weight;
    }

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setCoffeeWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(coffeeId, coffee.coffeeId) && Objects.equals(coffeeName, coffee.coffeeName) && Objects.equals(weight, coffee.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeId, coffeeName, weight);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId=" + coffeeId +
                ", coffeeName='" + coffeeName + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
