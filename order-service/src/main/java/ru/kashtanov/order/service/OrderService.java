package ru.kashtanov.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kashtanov.order.dto.OrderAndOrderLineItemDto;
import ru.kashtanov.order.dto.OrderLineItemsDto;
import ru.kashtanov.order.dto.OrderRequestDto;
import ru.kashtanov.order.model.Order;
import ru.kashtanov.order.model.OrderLineItems;
import ru.kashtanov.order.repository.OrderLineItemsRepository;
import ru.kashtanov.order.repository.OrderRepository;

import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderLineItemsRepository orderLineItemsRepository;

    public OrderService(OrderRepository orderRepository, OrderLineItemsRepository orderLineItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderLineItemsRepository = orderLineItemsRepository;
    }
    public void makeOrder(OrderRequestDto orderRequestDto){
        Order order = new Order();
        order.setOrderNumber(orderRequestDto.getOrderNumber());

        List<OrderLineItems> orderLineItemsList = orderRequestDto.getOrderLineItemsListDto()
                .stream()
                .map(orderLineItemsDto -> mapFromDto(orderLineItemsDto))
                .toList();
        System.out.println(orderRequestDto.getOrderLineItemsListDto().toString());

        order.setOrderLineItems(orderLineItemsList);
        orderRepository.saveAndFlush(order);
    }

    public OrderLineItems mapFromDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return  orderLineItems;
    }

    public List<Order> getAllOrderList(){
       return orderRepository.findAll();
    }

    public void addOrderToList(OrderRequestDto orderRequestDto){
        Order order = new Order();
        order.setOrderNumber(orderRequestDto.getOrderNumber());
        orderRepository.save(order);
    }

    public void assignOrderLineItem(OrderAndOrderLineItemDto dto){
        Order order = orderRepository.findById(dto.getOrderId()).orElseThrow();
        OrderLineItems orderLineItems = orderLineItemsRepository.findById(dto.getOrderLineItemId()).orElseThrow();
        List<OrderLineItems> orderLineItems1 = order.getOrderLineItems();
        orderLineItems1.add(orderLineItems);
        order.setOrderLineItems(orderLineItems1);
        orderRepository.saveAndFlush(order);
    }


}
