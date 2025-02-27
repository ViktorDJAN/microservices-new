package ru.kashtanov.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kashtanov.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
