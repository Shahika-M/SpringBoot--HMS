package com.example.SpringBootHMS.serviceImpl;
import java.util.*;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.SpringBootHMS.entity.Patient;
import com.example.SpringBootHMS.exception.ResourceNotFound;

import com.example.SpringBootHMS.repository.PatientRepository;

import com.example.SpringBootHMS.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
private PatientRepository patientRepository;
	
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}


	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}


	@Override
	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
		
	}

	@Override
	public Patient getPatientById(int id) {
		Optional<Patient> patient = patientRepository.findById(id);//4
		if(patient.isPresent()) {
			return patient.get();
		}
		else {
          
			throw new ResourceNotFound("Patient","Id",id);
		}
		
	}


	@Override
	public Patient updatePatient(Patient patient, int id) {
		Patient p = new Patient();
	 try {
		
		   p = patientRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Patient","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 
	 p.setFirstName(patient.getFirstName()); 
	 p.setLastName(patient.getLastName());
	 p.setAge(patient.getAge());
	 p.setWeight(patient.getWeight());
	 p.setBloodGrp(patient.getBloodGrp());
	 p.setGender(patient.getGender());
	 p.setCity(patient.getCity());
	 
	 p.setPhoneNo(patient.getPhoneNo());
	 p.setSpecialization(patient.getSpecialization());
	 p.setDisease(patient.getDisease());
	 p.setUsername(patient.getUsername());
	 p.setPwd(patient.getPwd());
	// p.setDid(patient.getDid());
	 patientRepository.save(p);
	return p;
	}
	
	@Override
	public void deletePatient(int id) {
		
		patientRepository.findById(id).orElseThrow(
				()->new ResourceNotFound("Patient","Id",id));
		patientRepository.deleteById(id);
		
	}
	
	@Override
	public List<Patient> getPatientByFirstName(String firstName) {
				return patientRepository.findPatientByFirstName(firstName);
	}
	@Override
	public List<Patient> getPatientByLastName(String lastName) {
				return patientRepository.findPatientByLastName(lastName);
	}


	@Override
	public List<Patient> getPatientByCity(String City) {
				return patientRepository.findPatientByCity(City);
	}
	
	/*@Override
	public List<Patient> getPatientByDoctor(int id) {
				return patientRepository.findDoctorById(id);
	}*/
	
	@Override
	public List<Patient> getPatientByFirstNameAndLastName(String firstName, String lastName) {
		return patientRepository.findPatientByFirstNameAndLastName(firstName, lastName);
	}



	

}
