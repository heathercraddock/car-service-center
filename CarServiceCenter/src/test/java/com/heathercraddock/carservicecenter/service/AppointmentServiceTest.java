package com.heathercraddock.carservicecenter.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.heathercraddock.carservicecenter.domain.Appointment;
import com.heathercraddock.carservicecenter.repository.AppointmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppointmentServiceTest {
	
	private List<Appointment> appointmentList;
	
	@Mock
	private AppointmentRepository aRepo;
	
	@InjectMocks
	@Autowired
	private AppointmentService aService;
	
	private int appointmentId;
	private Appointment appointment;
	private Date testDate = new Date();
	
	@BeforeEach
	void setup() throws Exception {
		Appointment appt = new Appointment(1, "Test car", "Test plate" , "Test customer", "Test phone", "Test description", "Test status", (float)1.99, testDate);
		appointmentId = appt.getId();
		appointment = appt;
	}
	
	@AfterEach
	void tearDown() {
		for(Appointment appt: aService.listAllAppointments()) {
			aService.cancelAppt(appt.getId());
		}
	}
	
	@Test
	void addOneAppointmentTest() {
		aService.saveAppointment(appointment);
		assertEquals(1, aService.listAllAppointments().size());
	}
	
	@Test
	void addMultipleAppointmentsTest() {
		Appointment appt2 = new Appointment(0, "Test car2", "Test plate2" , "Test customer2", "Test phone2", "Test description2", "Test status2", (float)2.99, testDate);
		Appointment appt3 = new Appointment(0, "Test car3", "Test plate3" , "Test customer3", "Test phone3", "Test description3", "Test status3", (float)3.99, testDate);
		Appointment appt4 = new Appointment(0, "Test car4", "Test plate4" , "Test customer4", "Test phone4", "Test description4", "Test status4", (float)4.99, testDate);
		Appointment appt5 = new Appointment(0, "Test car5", "Test plate5" , "Test customer5", "Test phone5", "Test description5", "Test status5", (float)5.99, testDate);
		aService.saveAppointment(appointment);
		aService.saveAppointment(appt2);
		aService.saveAppointment(appt3);
		aService.saveAppointment(appt4);
		aService.saveAppointment(appt5);
		
		assertEquals(5 , aService.listAllAppointments().size());
		
	}
	
	@Test
	void getOneApptById() {
		aService.saveAppointment(appointment);
		Appointment expected = new Appointment(1, "Test car", "Test plate" , "Test customer", "Test phone", "Test description", "Test status", (float)1.99, testDate);
		Appointment actual = aService.getAppt(appointment.getId());
		System.out.println("actual: " + actual.toString());
		System.out.println("expected: " + expected.toString());
		assertEquals(actual, expected);
	}
	
	@Test
	void deleteAppointmentTest() {
		aService.saveAppointment(appointment);
		aService.cancelAppt(appointment.getId());
		assertEquals(0, aService.listAllAppointments().size());
	}
	
	@Test
	void completeAppointmentTest() {
		System.out.println(aService.listAllAppointments().size());
		System.out.println(appointment.toString());
		aService.saveAppointment(appointment);
		System.out.println(aService.listAllAppointments().size());
		aService.completeAppt(appointment.getId());
		assertEquals("complete", (aService.getAppt(appointment.getId())).getStatus());
		
	}


}
