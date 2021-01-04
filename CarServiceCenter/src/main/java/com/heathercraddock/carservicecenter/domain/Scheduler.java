package com.heathercraddock.carservicecenter.domain;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.heathercraddock.carservicecenter.repository.AppointmentRepository;


@Component
public class Scheduler {
	
	@Autowired
	private AppointmentRepository repo;
	
	private String[] names = {"Bill gates", "Tom Jones", "Sarah Thomas", "Bob Dylan", "Michael Jackson", "Paige Turner", "Taylor Swift", "Ann Danother"};
	private String[] cars = {"Toyota Corolla", "Ford Focus", "Toyota Prius", "Dodge Challenger", "Ford F-250", "Pontiac Vibe", "Honda Accord"};
	private String[] services = {"Oil change", "Brake check", "Tire rotation", "Battery replacement", "Unknown clanking sound", "Change air filters"};
	
	private String alphanumericCharacters = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private String numericCharacters = 
            "0123456789";
	private Random random = new Random();
	
	@Scheduled(fixedDelay = 5000)
	public void randomIntervalGenerate() throws InterruptedException {
	    Appointment newAppointment = returnRandomAppointment();
	    repo.save(newAppointment);
	    System.out.println("Random appointment generated : " + newAppointment.toString());
	    
	    
	    try{
	    	Thread.sleep((long)(Math.random() * 60000));
	    } catch (InterruptedException e) {
	         Thread.currentThread().interrupt();
	    }
	}
	
	
	public Appointment returnRandomAppointment() {
		int minPrice = 0;
		int maxPrice = 1000;
		Appointment appt = new Appointment(cars[new Random().nextInt(cars.length)], randomString(6, alphanumericCharacters) , 
				names[new Random().nextInt(names.length)], randomString(10, numericCharacters), services[new Random().nextInt(services.length)], 
				"incomplete", Math.round((float) (minPrice + random.nextFloat() * (maxPrice-minPrice))/100.0));
		return appt;
	}
	
	
	public String randomString(int length, String allowedChars) {
		StringBuilder randomString = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			int randomInt = random.nextInt(allowedChars.length());
			randomString.append(allowedChars.charAt(randomInt));
		}
		
		return randomString.toString();
	}

	
	
	

}
