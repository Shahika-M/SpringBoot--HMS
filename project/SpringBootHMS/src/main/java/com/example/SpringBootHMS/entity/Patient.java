package com.example.SpringBootHMS.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JsonManagedReference;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="patientDetail")

public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private int id;
	@Column(name="f_name")
	private String firstName;
	@Column(name="l_name")
	private String lastName;
	
	@Column
	private int age;
	@Column
	private float weight;
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
	private String disease;
	@Column
	private String username;
	@Column
	private String pwd;
	

	
	
	@ManyToOne
	@JsonManagedReference
	//@JoinTable(name="doctor_patient", joinColumns= { @JoinColumn(name="pat_id")}, inverseJoinColumns= { @JoinColumn(name="doc_id")})
     @JoinColumn(name="d_id")
    private Doctor doctor;

	
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
