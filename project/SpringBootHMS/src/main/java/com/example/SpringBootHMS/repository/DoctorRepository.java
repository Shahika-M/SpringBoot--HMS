package com.example.SpringBootHMS.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootHMS.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
	
	List<Doctor>findDoctorByFirstName(String firstName);
	List<Doctor>findDoctorByLastName(String lastName);
	List<Doctor>findDoctorByCity(String city);
	List<Doctor>findDoctorBySpecialization(String specialization);
	//List<Doctor>findDoctorByFirstNameAndLastName(String firstName,String lastName);
	      

}
