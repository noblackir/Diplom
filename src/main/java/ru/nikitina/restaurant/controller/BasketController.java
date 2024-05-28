package ru.nikitina.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikitina.restaurant.model.Basket;
import ru.nikitina.restaurant.service.BasketService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    BasketService basketService;


//    @PostMapping("/{clientId}}")
//    public ResponseEntity<Basket> newBasket(@PathVariable Long clientId,
//                                            @RequestBody Basket basket){
//        return new ResponseEntity<>(basketService.save(clientId, basket), HttpStatus.OK);
//    }
}
