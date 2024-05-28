package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
}
