package com.example.SpringBootHMS.repository;



import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootHMS.entity.Receptionalist;

public interface ReceptionalistRepository extends JpaRepository<Receptionalist,Integer>{
	
	List<Receptionalist>findReceptionalistByFirstName(String firstName);
	List<Receptionalist>findReceptionalistByLastName(String lastName);
	List<Receptionalist>findReceptionalistByCity(String city);
	//List<Doctor>findDoctorByFirstNameAndLastName(String firstName,String lastName);
	      

}
