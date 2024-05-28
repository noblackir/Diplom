package ru.nikitina.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitina.restaurant.model.Client;
import ru.nikitina.restaurant.model.Dish;
import ru.nikitina.restaurant.model.Rating;
import ru.nikitina.restaurant.repository.DishRepository;
import ru.nikitina.restaurant.repository.RatingRepository;

import java.util.List;

@Service
public class DishService {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    RatingRepository repository;

    public List<Dish> all() {
        return (List<Dish>) dishRepository.findAll();
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish findOne(Long id) {
        return dishRepository.findById(id).get();
    }

    public Dish rate(Long dishId, Long clientId, Long rate) {
        Client client = clientService.getClient(clientId);
        Dish dish = dishRepository.findById(dishId).get();
        Rating rating = new Rating();
        rating.setGrade(rate);
        rating.setClient(client);
        rating.setDish(dish);
        List<Rating> ratings = dish.getRatings();
        ratings.add(rating);
        dish.setRatings(ratings);
        return dishRepository.save(dish);
    }
}
