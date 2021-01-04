package com.heathercraddock.carservicecenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Appointment> findAppointmentAsPage(int id){
		Pageable pageable = PageRequest.of(0, 1);
		return repo.findById(id, pageable);
	}
	
	public Page<Appointment> findPaginated(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return repo.findAll(pageable);
	}
	
	public Page<Appointment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(Sort.Order.asc(sortField).ignoreCase()) :
			Sort.by(Sort.Order.desc(sortField).ignoreCase());
		Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
		return repo.findAll(pageable);	
	}

	public Page<Appointment> findPaginatedbyDate(int pageNo, int pageSize, String sortField, String sortDirection, Date startDate, Date endDate){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(Sort.Order.asc(sortField).ignoreCase()) :
			Sort.by(Sort.Order.desc(sortField).ignoreCase());
		Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
		return repo.findAllByDateCreatedBetween(startDate, endDate, pageable);
	}
	

}
