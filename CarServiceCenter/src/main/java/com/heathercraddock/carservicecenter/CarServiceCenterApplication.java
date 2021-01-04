package com.heathercraddock.carservicecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication

@EnableScheduling

public class CarServiceCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceCenterApplication.class, args);
	}

}
