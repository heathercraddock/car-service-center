package com.heathercraddock.carservicecenter;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.heathercraddock.carservicecenter.domain.Appointment;
import com.heathercraddock.carservicecenter.repository.AppointmentRepository;

@SpringBootApplication

//@EnableScheduling

public class CarServiceCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceCenterApplication.class, args);
	}

}
