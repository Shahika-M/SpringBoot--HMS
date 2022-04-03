package com.example.SpringBootHMS.repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootHMS.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	List<Patient>findPatientByFirstName(String firstName);
	List<Patient>findPatientByLastName(String lastName);
	List<Patient>findPatientByCity(String city);
	List<Patient>findPatientByFirstNameAndLastName(String firstName,String lastName);
	
	
	      
	      
}
