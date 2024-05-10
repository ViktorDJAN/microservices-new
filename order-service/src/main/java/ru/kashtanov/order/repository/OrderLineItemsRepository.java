package ru.kashtanov.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kashtanov.order.model.OrderLineItems;
@Repository
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems,Integer> {
}
