package ru.kashtanov.coffee_shop.dto;

import java.util.Objects;

public class ArabicaDtoResponse {
    private Integer coffeeId;
    private String coffeeName;
    private Double weight;

    public ArabicaDtoResponse() {
    }

    public ArabicaDtoResponse(Integer coffeeId, String coffeeName, Double weight) {
        this.coffeeId = coffeeId;
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

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArabicaDtoResponse that = (ArabicaDtoResponse) o;
        return Objects.equals(coffeeId, that.coffeeId) && Objects.equals(coffeeName, that.coffeeName) && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeId, coffeeName, weight);
    }

    @Override
    public String toString() {
        return "ArabicaDtoResponse{" +
                "coffeeId=" + coffeeId +
                ", coffeeName='" + coffeeName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
