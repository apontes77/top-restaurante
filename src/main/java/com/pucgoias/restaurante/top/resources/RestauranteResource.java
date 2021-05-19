package com.pucgoias.restaurante.top.resources;

import com.pucgoias.restaurante.top.models.Restaurant;
import com.pucgoias.restaurante.top.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestauranteResource {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> listAllRestaurants () {
        List<Restaurant> restaurants = new ArrayList<>();
               restaurants =  restaurantRepository.findAll();
        return ResponseEntity.ok().body(restaurants);
    }

    @PostMapping
    public ResponseEntity<Restaurant> insert(@RequestBody Restaurant restaurant) {
        Restaurant restaurantNew = restaurantRepository.save(restaurant);
        return ResponseEntity.ok().body(restaurantNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
