package ru.kashtanov.order.service;

import org.springframework.stereotype.Service;
import ru.kashtanov.order.dto.OrderLineItemsDto;
import ru.kashtanov.order.model.OrderLineItems;
import ru.kashtanov.order.repository.OrderLineItemsRepository;

import java.util.List;

@Service
public class OrderLineItemsService {

    private final OrderLineItemsRepository orderLineItemsRepository;

    public OrderLineItemsService(OrderLineItemsRepository orderLineItemsRepository) {
        this.orderLineItemsRepository = orderLineItemsRepository;
    }

    public void addOrderLineItems(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItemsRepository.save(orderLineItems);
    }
    public List<OrderLineItems> getAllItemLineItems(){
       return orderLineItemsRepository.findAll();
    }
}
