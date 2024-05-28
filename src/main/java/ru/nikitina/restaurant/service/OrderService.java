package ru.nikitina.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitina.restaurant.model.*;
import ru.nikitina.restaurant.repository.OrderRepository;
import ru.nikitina.restaurant.repository.OrderStatusRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderStatusRepository orderStatusRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    DishService dishService;
    @Autowired
    BasketService basketService;
    public Order newOrder(Long clientId) {
        Client client = clientService.clientRepository.findById(clientId).get();
        OrderStatus orderStatus = orderStatusRepository.findByTitle("Создается");

        Order order = new Order();
        order.setClient(client);
        order.setOrderStatus(orderStatus);

        return orderRepository.save(order);
    }

    public Order addBasket(Long clientId,Long dishId, Long count){
        Basket basket = new Basket();
        Dish dish = dishService.findOne(dishId);
        Order order = orderRepository.findFirstByClientId(clientId);
        OrderStatus orderStatus = orderStatusRepository.findByTitle("Создается");
        basket.setDish(dish);
        basket.setCount(count);
        basket.setOrder(order);

        List<Basket> baskets = order.getBaskets();
        baskets.add(basket);
        order.setBaskets(baskets);
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }

    public Order status(Long clientId, String status, Order orderFromClient) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        orders.sort(Comparator.comparing(Order::getId));

        Order order = orders.get(orders.size() - 1);

        OrderStatus orderStatus;
        if (Objects.equals(status, "В доставке")){
            orderStatus = orderStatusRepository.findByTitle("В доставке");
            order.setOrderStatus(orderStatus);
        } else {
            if (orderFromClient != null){
                orderStatus = orderStatusRepository.findByTitle("Завершен");
                order.setAddress(orderFromClient.getAddress());
                Double cost = order.getBaskets().stream().mapToDouble(basket -> basket.getDish().getCost()).sum();
                order.setTotal_price(cost);
                order.setAcceptance_date(Date.from(new Date().toInstant()));
                newOrder(clientId);
                order.setOrderStatus(orderStatus);
            }
        }
        return orderRepository.save(order);
    }

    public Order findOne(Long clientId) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        orders.sort(Comparator.comparing(Order::getId));
        return orders.get(orders.size() - 1);
    }


    public List<Order> findAll(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }

    public void firstBasket(Client client1) {
        OrderStatus orderStatus = orderStatusRepository.findByTitle("Создается");

        Order order = new Order();
        order.setClient(client1);
        order.setOrderStatus(orderStatus);

        orderRepository.save(order);
    }
}
