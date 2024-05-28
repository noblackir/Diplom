package ru.nikitina.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikitina.restaurant.model.Dish;
import ru.nikitina.restaurant.model.Role;
import ru.nikitina.restaurant.service.DishService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishService dishService;

    @PostMapping
    public ResponseEntity<Dish> post(@RequestBody Dish dish){
        return new ResponseEntity<>(dishService.save(dish), HttpStatus.CREATED);
    }

    @PostMapping("/{dishId}/{clientId}/{rate}")
    public ResponseEntity<Dish> rate(@PathVariable(name = "dishId") Long dishId,
                                     @PathVariable(name = "clientId") Long clientId,
                                     @PathVariable(name = "rate") Long rate){
        return new ResponseEntity<>(dishService.rate(dishId, clientId, rate), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> all(){
        return new ResponseEntity<>(dishService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> oneDish(@PathVariable Long id){
        return new ResponseEntity<>(dishService.findOne(id), HttpStatus.OK);
    }

}
