package com.example.SpringBootHMS.service;

import java.util.*;
import com.example.SpringBootHMS.entity.Patient;

public interface PatientService {
	
	
	Patient savePatient(Patient patient);
	List<Patient> getAllPatient();
	Patient getPatientById(int id);
	Patient updatePatient(Patient patient,int id);
	void deletePatient(int id);
	List<Patient>getPatientByFirstName(String firstName);
	List<Patient>getPatientByLastName(String lastName);
	List<Patient>getPatientByCity(String city);
	List<Patient>getPatientByFirstNameAndLastName(String firstName,String lastName);
   // List<Patient>getPatientByDoctor(int id);
}
