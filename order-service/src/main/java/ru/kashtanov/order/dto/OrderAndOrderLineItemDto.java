package ru.kashtanov.order.dto;

public class OrderAndOrderLineItemDto {
    private Integer orderId;
    private Integer orderLineItemId;

    public OrderAndOrderLineItemDto() {
    }

    public OrderAndOrderLineItemDto(Integer orderId, Integer orderLineItemId) {
        this.orderId = orderId;
        this.orderLineItemId = orderLineItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderLineItemId() {
        return orderLineItemId;
    }

    public void setOrderLineItemId(Integer orderLineItemId) {
        this.orderLineItemId = orderLineItemId;
    }

    @Override
    public String toString() {
        return "OrderAndOrderLineItemDto{" +
                "orderId=" + orderId +
                ", orderLineItemId=" + orderLineItemId +
                '}';
    }
}
