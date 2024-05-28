package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.Order;
import ru.nikitina.restaurant.model.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findFirstByClientId(Long clientId);

    List<Order> findByClientId(Long clientId);

}
