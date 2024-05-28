package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.Dish;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
}
