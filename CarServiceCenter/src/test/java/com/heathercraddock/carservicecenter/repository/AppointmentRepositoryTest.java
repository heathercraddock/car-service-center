package com.heathercraddock.carservicecenter.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.heathercraddock.carservicecenter.domain.Appointment;
import com.heathercraddock.carservicecenter.service.AppointmentService;

@DataJpaTest
class AppointmentRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AppointmentRepository repo;
	
	@Test
	void findAppointmentByIdTest() throws Exception {
		Date testDate = new Date();
		this.entityManager.persist(new Appointment(0, "Test car", "Test plate" , "Test customer", "Test phone", "Test description", "Test status", (float)9.99, testDate));
		Appointment appt = (repo.findById(1)).orElse(new Appointment());
		assertThat(appt.getCustomerName()).isEqualTo("Test customer");
		entityManager.clear();
	}
	

}
