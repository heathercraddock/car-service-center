package com.heathercraddock.carservicecenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heathercraddock.carservicecenter.domain.Appointment;
import com.heathercraddock.carservicecenter.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;
	
	public List<Appointment> listAllAppointments() {
		return repo.findAll();
	}
	
	public Appointment getAppt(int id) {
		return repo.findById(id).get();
	}
	
	public void cancelAppt(int id) {
		repo.deleteById(id);
	}
	
	public void completeAppt(int id) {
		Appointment a = repo.findById(id).get();
		a.setStatus("complete");
		saveAppointment(a);
	}
	
	
	public void saveAppointment(Appointment appt) {
		repo.save(appt);
	}

}
