package ru.kashtanov.coffee_shop.dto;

import java.util.Objects;

public class ArabicaDtoRequest {
    private String coffeeName;
    private Double weight;

    public ArabicaDtoRequest() {
    }

    public ArabicaDtoRequest(String coffeeName, Double weight) {
        this.coffeeName = coffeeName;
        this.weight = weight;
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
        ArabicaDtoRequest that = (ArabicaDtoRequest) o;
        return Objects.equals(coffeeName, that.coffeeName) && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeName, weight);
    }

    @Override
    public String toString() {
        return "ArabicaDtoRequest{" +
                "coffeeName='" + coffeeName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
