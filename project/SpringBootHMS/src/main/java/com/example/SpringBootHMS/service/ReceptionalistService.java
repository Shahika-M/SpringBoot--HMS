package com.example.SpringBootHMS.service;

import java.util.*;
import com.example.SpringBootHMS.entity.Receptionalist;

public interface ReceptionalistService {
	
	
	Receptionalist saveReceptionalist(Receptionalist receptionalist);
	List<Receptionalist> getAllReceptionalist();
	Receptionalist getReceptionalistById(int id);
	Receptionalist updateReceptionalist(Receptionalist receptionalist,int id);
	void deleteReceptionalist(int id);
	List<Receptionalist>getReceptionalistByFirstName(String firstName);
	List<Receptionalist>getReceptionalistByLastName(String lastName);
	List<Receptionalist>getReceptionalistByCity(String city);
	//List<Receptionalist>getReceptionalistByFirstNameAndLastName(String firstName,String lastName);


}



