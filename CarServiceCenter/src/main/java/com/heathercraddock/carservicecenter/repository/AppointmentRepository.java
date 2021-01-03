package com.heathercraddock.carservicecenter.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heathercraddock.carservicecenter.domain.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	Page<Appointment> findAllByDateCreatedBetween(Date startDate, Date endDate, Pageable pageable);

	Page<Appointment> findById(int id, Pageable pageable);
	
}
