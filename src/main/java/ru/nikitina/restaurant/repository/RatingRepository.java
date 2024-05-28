package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {
}
