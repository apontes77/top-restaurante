package com.pucgoias.restaurante.top;

import com.pucgoias.restaurante.top.models.Order;
import com.pucgoias.restaurante.top.models.Restaurant;
import com.pucgoias.restaurante.top.repository.OrderRepository;
import com.pucgoias.restaurante.top.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class TopApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(TopApplication.class, args);
	}

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		Order o1 = new Order(null,
				"pizza calabresa que beleza",
				LocalDate.now(),
				"bit.ly/my-photo",
				new BigDecimal("34.90"));

		Order o2 = new Order(null,
				"pizza portuguesa que beleza",
				LocalDate.now(),
				"https://drive.google.com/file/d/1oZf_IsktvBok83mddbRJ9LCcztHu2u2T/view?usp=sharing",
				new BigDecimal("34.90"));

		Restaurant restaurant1 = new Restaurant(null,
				"TOP RESTAURANTE",
				"SUA FOME É NOSSO DESEJO");
		Restaurant restaurant2 = new Restaurant(null,
				"BARRIGA VERDE RESTAURANTE",
				"O VERDADEIRO PROGRAMA FOME ZERO");


		List<Restaurant> restaurants = new ArrayList<>(Arrays.asList(restaurant1, restaurant2));

		restaurantRepository.saveAll(restaurants);
		orderRepository.saveAll(Arrays.asList(o1, o2));
	}
}
