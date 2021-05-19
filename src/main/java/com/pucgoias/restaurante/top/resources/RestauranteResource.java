package com.pucgoias.restaurante.top.resources;

import com.pucgoias.restaurante.top.models.Restaurant;
import com.pucgoias.restaurante.top.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestauranteResource {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getRestaurants () {
        List<Restaurant> restaurants = new ArrayList<>();
               restaurants =  restaurantRepository.findAll();
        return ResponseEntity.ok().body(restaurants);
    }

}
