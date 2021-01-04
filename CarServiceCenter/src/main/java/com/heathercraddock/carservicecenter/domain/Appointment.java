package com.heathercraddock.carservicecenter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String car;
	@Column(name = "plate_num")
	private String plateNum;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_phone")
	private String customerPhone;
	
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


	public Appointment(int id, String car, String plateNum , String customerName, String customerPhone, String apptDesc, String status, float price,
			Date dateCreated) {
		super();
		this.id = id;
		this.car = car;
		this.plateNum = plateNum;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.apptDesc = apptDesc;
		this.status = status;
		this.price = price;
		this.dateCreated = dateCreated;
	}
	
	public Appointment(String car, String plateNum , String customerName, String customerPhone, String apptDesc, String status, float price) {
		super();
		this.car = car;
		this.plateNum = plateNum;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.apptDesc = apptDesc;
		this.status = status;
		this.price = price;
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


	public String getPlateNum() {
		return plateNum;
	}


	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
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


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", car=" + car + ", plateNum=" + plateNum + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", apptDesc=" + apptDesc + ", status=" + status + ", price="
				+ price + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
	
	
}