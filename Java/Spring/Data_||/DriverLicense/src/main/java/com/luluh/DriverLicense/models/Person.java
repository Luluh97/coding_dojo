package com.luluh.DriverLicense.models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 private License license;
 
 public Person() {
     
 }
 public void setId(Long id) {
		this.id = id;
	}
 
 public Long getId() {
		return id;
	}
 
 
 public String getNumber() {
		return lastName;
	}
 
 public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
 
 public String getfirstName() {
		return firstName;
	}
 
 public void setlastName(String lastName) {
		this.lastName = lastName;
	}
 
 public String getlastName() {
		return lastName;
	}
 
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
 @PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
}