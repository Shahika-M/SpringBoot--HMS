package com.example.SpringBootHMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import java.util.*;
import lombok.Data;

@Data
@Entity
@Table(name="doctorDetail")

public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d_id")
	private int id;
	@Column(name="f_name")
	private String firstName;
	@Column(name="l_name")
	private String lastName;
	
	@Column
	private int age;

	@Column(name="blood_grp")
	private String bloodGrp;
	@Column
	private String gender;
	@Column
	private String city;
	@Column(name="phone_no")
	private String phoneNo;
	@Column
	private String specialization;

	@Column
	private String username;
	@Column
	private String pwd;
	
	
	@OneToMany(mappedBy="doctor")
	@JsonBackReference
   private List<Patient> patient;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
}
