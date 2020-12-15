package com.app.BankManagement.Model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="account")
public class Account {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Please provide  customerType")
	@Column(name = "customerType", columnDefinition = "VARCHAR(20)")
	private String customerType;
	@Column(name = "accNo", columnDefinition = "VARCHAR(20)")
	private String accNo;
	@NotEmpty(message = "Please provide  name")
	@Column(name = "name", columnDefinition = "VARCHAR(20)")
	private String name;
	@NotNull(message = "Please provide  dob")
	@Column(name = "dob")
	private Date dob;
	@NotEmpty(message = "Please provide  gender")
	@Column(name = "gender", columnDefinition = "VARCHAR(20)")
	private String gender;
	@NotEmpty(message = "Please provide  nationality")
	@Column(name = "nationality", columnDefinition = "VARCHAR(20)")
	private String nationality;
	@NotEmpty(message = "Please provide  martialStatus")
	@Column(name = "martialStatus", columnDefinition = "VARCHAR(20)")
	private String martialStatus;
	private boolean status;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
	private boolean deleteFlag;
	@OneToOne(targetEntity = Address.class, cascade= {CascadeType.ALL})
	@JoinColumn(name="addressRefereceId", referencedColumnName = "id")
	private Address address;
	@OneToOne(targetEntity = Nominee.class, cascade= {CascadeType.ALL})
	@JoinColumn(name="nomineeRefereceId", referencedColumnName = "id")
	private Nominee nominee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Nominee getNominee() {
		return nominee;
	}
	public void setNominee(Nominee nominee) {
		this.nominee = nominee;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	
}
