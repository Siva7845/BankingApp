package com.app.BankManagement.Model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="nominee")
public class Nominee {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "nomineeName", columnDefinition = "VARCHAR(20)")
	private String nomineeName;
	@Column(name = "acno", columnDefinition = "VARCHAR(50)")
	private String acno;
	@Column(name = "accountType", columnDefinition = "VARCHAR(20)")
	private String accountType;
	@Column(name = "relationship", columnDefinition = "VARCHAR(50)")
	private String relationship;
	@Column(name = "mobileno", columnDefinition = "VARCHAR(20)")
	private String mobileno;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
	@OneToOne(targetEntity = Address.class, cascade= {CascadeType.ALL})
	@JoinColumn(name="addressRefereceId", referencedColumnName = "id")
	private Address addressNominee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Address getAddressNominee() {
		return addressNominee;
	}
	public void setAddressNominee(Address addressNominee) {
		this.addressNominee = addressNominee;
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
	public Nominee() {
		super();
	}
	
}
