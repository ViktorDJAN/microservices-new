package ru.kashtanov.order.controller;

import org.springframework.web.bind.annotation.*;
import ru.kashtanov.order.dto.OrderLineItemsDto;
import ru.kashtanov.order.model.OrderLineItems;
import ru.kashtanov.order.service.OrderLineItemsService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/orderLineItems")
public class OrderLineItemsController {

    private final OrderLineItemsService orderLineItemsService;

    public OrderLineItemsController(OrderLineItemsService orderLineItemsService) {
        this.orderLineItemsService = orderLineItemsService;
    }

    @GetMapping("/single")
    public OrderLineItems getSingleOrderLineItem() {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode("EE345");
        orderLineItems.setPrice(233.3);
        orderLineItems.setQuantity(3);
        return orderLineItems;
    }

    @GetMapping("/all")
    public List<OrderLineItems> getOrderLineItemsAllList() {
        return orderLineItemsService.getAllItemLineItems();
    }

    @PostMapping("/add")
    public String addOrderLineItem(@RequestBody OrderLineItemsDto orderLineItems) {
        orderLineItemsService.addOrderLineItems(orderLineItems);
        return "Order line item is successfully added";
    }

}
