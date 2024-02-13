package com.film;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EntityScan(basePackages = {"com.film"})
public class CinemaBookingEsakkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBookingEsakkyApplication.class, args);
	}

}
