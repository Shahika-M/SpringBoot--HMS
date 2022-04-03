package com.example.SpringBootHMS.serviceImpl;

import java.util.*;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.SpringBootHMS.entity.Doctor;
import com.example.SpringBootHMS.exception.ResourceNotFound;

import com.example.SpringBootHMS.repository.DoctorRepository;

import com.example.SpringBootHMS.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
private DoctorRepository doctorRepository;
	
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}


	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}


	@Override
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}


	@Override
	public Doctor getDoctorById(int id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if(doctor.isPresent()) {
			return doctor.get();
		}
		else {
          
			throw new ResourceNotFound("doctor","Id",id);
		}
		
	}


	@Override
	public Doctor updateDoctor(Doctor doctor, int id) {
		Doctor d = new Doctor();
	 try {
		
		   d = doctorRepository.findById(id).orElseThrow(//4
				 ()-> 		 new ResourceNotFound("doctor","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 
	 d.setFirstName(doctor.getFirstName()); 
	 
	 // a(emp)  - > A(employee)
	 
	 d.setLastName(doctor.getLastName());
	 d.setAge(doctor.getAge());
	 
	 d.setBloodGrp(doctor.getBloodGrp());
	 d.setGender(doctor.getGender());
	 d.setCity(doctor.getCity());
	 
	 d.setPhoneNo(doctor.getPhoneNo());
	 d.setSpecialization(doctor.getSpecialization());
	
	 d.setUsername(doctor.getUsername());
	 d.setPwd(doctor.getPwd());
	 doctorRepository.save(d);
	return d;
	}
	
	@Override
	public void deleteDoctor(int id) {
		
		doctorRepository.findById(id).orElseThrow(
				()->new ResourceNotFound("doctor","Id",id));
		doctorRepository.deleteById(id);
		
	}
	
	@Override
	public List<Doctor> getDoctorByFirstName(String firstName) {
				return doctorRepository.findDoctorByFirstName(firstName);
	}
	@Override
	public List<Doctor> getDoctorByLastName(String lastName) {
				return doctorRepository.findDoctorByLastName(lastName);
	}


	@Override
	public List<Doctor> getDoctorByCity(String City) {
				return doctorRepository.findDoctorByCity(City);
	}

	
	@Override
	public List<Doctor> getDoctorBySpecialization(String Specialization) {
				return doctorRepository.findDoctorBySpecialization(Specialization);
	}

}
