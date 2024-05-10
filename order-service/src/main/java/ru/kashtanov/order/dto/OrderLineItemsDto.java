package ru.kashtanov.order.dto;

import java.util.Objects;

public class OrderLineItemsDto {
    private String skuCode;
    private Double price;
    private Integer quantity;

    public OrderLineItemsDto() {
    }

    public OrderLineItemsDto(String skuCode, Double price, Integer quantity) {
        this.skuCode = skuCode;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineItemsDto that = (OrderLineItemsDto) o;
        return Objects.equals(skuCode, that.skuCode) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuCode, price, quantity);
    }

    @Override
    public String toString() {
        return "OrderLineItemsDto{" +
                "skuCode='" + skuCode + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
