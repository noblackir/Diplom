package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.OrderStatus;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {
    OrderStatus findByTitle(String title);
}
