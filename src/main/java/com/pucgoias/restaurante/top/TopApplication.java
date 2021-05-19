package com.pucgoias.restaurante.top;

import com.pucgoias.restaurante.top.models.Restaurant;
import com.pucgoias.restaurante.top.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class TopApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(TopApplication.class, args);
	}

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public void run(String... args) throws Exception {
		Restaurant restaurant1 = new Restaurant(null, "TOP RESTAURANTE","SUA FOME É NOSSO DESEJO");
		Restaurant restaurant2 = new Restaurant(null, "BARRIGA VERDE RESTAURANTE","O VERDADEIRO PROGRAMA FOME ZERO");

		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.addAll(Arrays.asList(restaurant1, restaurant2));

		restaurantRepository.saveAll(restaurants);
	}
}
