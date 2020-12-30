package com.heathercraddock.carservicecenter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class Appointment {
	
	/*
	 Create appointment class: must include a price, status, date (scheduled date? 
	 date appointment was made? date completed?). Must likely include: car details, 
	 customer details, description.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String car;
	private String customer;
	
	@Column(name = "appt_description")
	private String apptDesc;
	
	@Column(columnDefinition="text default 'incomplete'")
	private String status;
	
	private float price;
	
	@Column(name = "date_created", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable=false)
	private Date dateCreated; //current time, changes based on system/ time zone - TZ irrelevant for car scheduing
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(int id, String car, String customer, String apptDesc, String status, float price,
			Date dateCreated) {
		super();
		this.id = id;
		this.car = car;
		this.customer = customer;
		this.apptDesc = apptDesc;
		this.status = status;
		this.price = price;
		this.dateCreated = dateCreated;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCar() {
		return car;
	}


	public void setCar(String car) {
		this.car = car;
	}


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public String getApptDesc() {
		return apptDesc;
	}


	public void setApptDesc(String apptDesc) {
		this.apptDesc = apptDesc;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
	
	
}