package com.heathercraddock.carservicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heathercraddock.carservicecenter.domain.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
}
