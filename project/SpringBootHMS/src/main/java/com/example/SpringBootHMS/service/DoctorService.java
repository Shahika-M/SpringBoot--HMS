package com.example.SpringBootHMS.service;

import java.util.*;
import com.example.SpringBootHMS.entity.Doctor;

public interface DoctorService {
	
	
	Doctor saveDoctor(Doctor doctor);
	List<Doctor> getAllDoctor();
	Doctor getDoctorById(int id);
	Doctor updateDoctor(Doctor doctor,int id);
	void deleteDoctor(int id);
	List<Doctor>getDoctorByFirstName(String firstName);
	List<Doctor>getDoctorByLastName(String lastName);
	List<Doctor>getDoctorByCity(String city);
	List<Doctor>getDoctorBySpecialization(String specialization);
	//List<Doctor>getDoctorByFirstNameAndLastName(String firstName,String lastName);


}
