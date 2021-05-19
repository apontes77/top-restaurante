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

    @GetMapping(value = "/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> listOrdersByRestaurant (@PathVariable Long id) {
        List<Order> orders = new ArrayList<>();
        orders =  orderRepository.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order order) {
        Order orderNew = orderRepository.save(order);
        return ResponseEntity.ok().body(orderNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
