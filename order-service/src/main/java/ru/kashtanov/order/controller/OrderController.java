package ru.kashtanov.order.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.kashtanov.order.dto.OrderAndOrderLineItemDto;
import ru.kashtanov.order.dto.OrderLineItemsDto;
import ru.kashtanov.order.dto.OrderRequestDto;
import ru.kashtanov.order.model.Order;
import ru.kashtanov.order.model.OrderLineItems;
import ru.kashtanov.order.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/single")
    public OrderRequestDto getSingle() {
        OrderRequestDto order = new OrderRequestDto();
        order.setOrderNumber("AA2003");
//        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
//        orderLineItemsDto.setSkuCode("qw12");
//        orderLineItemsDto.setPrice(200.2);
//        orderLineItemsDto.setQuantity(4);
//        List<OrderLineItemsDto>orderLineItemsDtoList = new ArrayList<>();
//        orderLineItemsDtoList.add(orderLineItemsDto);
//        order.setOrderNumber("AB12");
//        order.setOrderLineItemsListDto(orderLineItemsDtoList);
        return order;

    }

    @GetMapping("/all")
    public List<Order> getAllListOrder() {
        return orderService.getAllOrderList();
    }

    @PostMapping("/addWithList")
    public String placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        System.out.println(orderRequestDto.getOrderLineItemsListDto());
        orderService.makeOrder(orderRequestDto);
        return "The order is successfully done";
    }

    @PostMapping("/addSingle")
    public String addOrder(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.addOrderToList(orderRequestDto);
        return "The order is successfully done";
    }

    @PostMapping("/assign")
    public String assignOrderLineItemToOrder(@RequestBody OrderAndOrderLineItemDto dto){
        System.out.println(dto);
        orderService.assignOrderLineItem(dto);
        return "The order line items is successfully assigned";
    }

    @GetMapping("/dto")
    public OrderAndOrderLineItemDto getDto(){
        OrderAndOrderLineItemDto orderAndOrderLineItemDto = new OrderAndOrderLineItemDto();
        orderAndOrderLineItemDto.setOrderId(1);
        orderAndOrderLineItemDto.setOrderLineItemId(1);
        return orderAndOrderLineItemDto;
    }
}
