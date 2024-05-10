package ru.kashtanov.order.dto;

import ru.kashtanov.order.model.OrderLineItems;

import java.util.List;
import java.util.Objects;

public class OrderRequestDto {
    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsListDto;


    public OrderRequestDto() {
    }

    public OrderRequestDto(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderRequestDto(String orderNumber, List<OrderLineItemsDto> orderLineItemsListDto) {
        this.orderNumber = orderNumber;
        this.orderLineItemsListDto = orderLineItemsListDto;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItemsDto> getOrderLineItemsListDto() {
        return orderLineItemsListDto;
    }

    public void setOrderLineItemsListDto(List<OrderLineItemsDto> orderLineItemsListDto) {
        this.orderLineItemsListDto = orderLineItemsListDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequestDto that = (OrderRequestDto) o;
        return Objects.equals(orderNumber, that.orderNumber) && Objects.equals(orderLineItemsListDto, that.orderLineItemsListDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderLineItemsListDto);
    }

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderLineItemsListDto=" + orderLineItemsListDto +
                '}';
    }
}
