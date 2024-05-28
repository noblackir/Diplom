package ru.nikitina.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikitina.restaurant.model.Order;
import ru.nikitina.restaurant.service.OrderService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/{clientId}")
    public ResponseEntity<Order> newOrder(@PathVariable Long clientId){
        return new ResponseEntity<>(orderService.newOrder(clientId), HttpStatus.OK);
    }

    @PostMapping("/{clientId}/{status}")
    public ResponseEntity<Order> status(@PathVariable Long clientId,
                                        @PathVariable String status,
                                        @RequestBody(required = false) Order order){
        return new ResponseEntity<>(orderService.status(clientId, status, order), HttpStatus.OK);
    }

    @PostMapping("/{clientId}/{dishId}/{count}")
    public ResponseEntity<Order> addBasket(@PathVariable Long clientId,
                                        @PathVariable Long dishId,
                                        @PathVariable Long count){
        return new ResponseEntity<>(orderService.addBasket(clientId, dishId, count), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Order> get(@PathVariable Long clientId){
        return new ResponseEntity<>(orderService.findOne(clientId), HttpStatus.OK);
    }

    @GetMapping("/all/{clientId}")
    public ResponseEntity<List<Order>> getAll(@PathVariable Long clientId){
        return new ResponseEntity<>(orderService.findAll(clientId), HttpStatus.OK);
    }
}
