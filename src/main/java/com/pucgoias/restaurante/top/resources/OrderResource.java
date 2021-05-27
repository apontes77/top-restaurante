package com.pucgoias.restaurante.top.resources;

import com.pucgoias.restaurante.top.models.Order;
import com.pucgoias.restaurante.top.models.Restaurant;
import com.pucgoias.restaurante.top.repository.OrderRepository;
import com.pucgoias.restaurante.top.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping( value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> listOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Order> insert(@RequestBody Order order) {
        Order newOrder = orderRepository.save(order);
        return ResponseEntity.ok().body(newOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
