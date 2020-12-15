package com.app.BankManagement.Model;

import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="address")
public class Address {

	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Please provide a doorNo")
	@Column(name = "doorNo", columnDefinition = "VARCHAR(20)")
	private String doorNo;
	@NotEmpty(message = "Please provide a landMark_Or_Street")
	@Column(name = "landMark_Or_Street", columnDefinition = "VARCHAR(100)")
	private String landMark_Or_Street;
	@NotEmpty(message = "Please provide a city")
	@Column(name = "city", columnDefinition = "VARCHAR(20)")
	private String city;
	@NotEmpty(message = "Please provide a pincode")
	@Column(name = "pincode", columnDefinition = "VARCHAR(20)")
	private String pincode;
	@NotEmpty(message = "Please provide a state")
	@Column(name = "state", columnDefinition = "VARCHAR(20)")
	private String state;
	@NotEmpty(message = "Please provide a mobileNumber")
	@Column(name = "mobileNumber", columnDefinition = "VARCHAR(20)")
	private String mobileNumber;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getLandMark_Or_Street() {
		return landMark_Or_Street;
	}
	public void setLandMark_Or_Street(String landMark_Or_Street) {
		this.landMark_Or_Street = landMark_Or_Street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
