package com.example.SpringBootHMS.serviceImpl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.SpringBootHMS.entity.Patient;
import com.example.SpringBootHMS.entity.Receptionalist;
import com.example.SpringBootHMS.exception.ResourceNotFound;

import com.example.SpringBootHMS.repository.ReceptionalistRepository;

import com.example.SpringBootHMS.service.ReceptionalistService;

@Service
public class ReceptionalistServiceImpl implements ReceptionalistService{
	
private ReceptionalistRepository receptionalistRepository;
	
	
	public ReceptionalistServiceImpl(ReceptionalistRepository receptionalistRepository) {
		super();
		this.receptionalistRepository = receptionalistRepository;
	}


	@Override
	public Receptionalist saveReceptionalist(Receptionalist receptionalist) {
		return receptionalistRepository.save(receptionalist);
	}


	@Override
	public List<Receptionalist> getAllReceptionalist() {
		return receptionalistRepository.findAll();
		
	}

	@Override
	public Receptionalist getReceptionalistById(int id) {//4
		Optional<Receptionalist> receptionalist = receptionalistRepository.findById(id);//4
		if(receptionalist.isPresent()) {
			return receptionalist.get();
		}
		else {
          
			throw new ResourceNotFound("Receptionalist","Id",id);
		}
		
	}


	@Override
	public Receptionalist updateReceptionalist(Receptionalist receptionalist, int id) {
		Receptionalist r = new Receptionalist();
	 try {
		
		   r = receptionalistRepository.findById(id).orElseThrow(//4
				 ()-> 		 new ResourceNotFound("Receptionalist","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 
	 r.setFirstName(receptionalist.getFirstName()); 
	 r.setLastName(receptionalist.getLastName());
	 r.setAge(receptionalist.getAge());
	 r.setBloodGrp(receptionalist.getBloodGrp());
	 r.setGender(receptionalist.getGender());
	 r.setCity(receptionalist.getCity());
	 
	 r.setPhoneNo(receptionalist.getPhoneNo());
	 r.setUsername(receptionalist.getUsername());
	 r.setPwd(receptionalist.getPwd());
	 receptionalistRepository.save(r);
	return r;
	}
	
	@Override
	public void deleteReceptionalist(int id) {
		
		receptionalistRepository.findById(id).orElseThrow(
				()->new ResourceNotFound("receptionalist","Id",id));
		receptionalistRepository.deleteById(id);
		
	}
	
	@Override
	public List<Receptionalist> getReceptionalistByFirstName(String firstName) {//john
				return receptionalistRepository.findReceptionalistByFirstName(firstName);
	}
	@Override
	public List<Receptionalist> getReceptionalistByLastName(String lastName) {//john
				return receptionalistRepository.findReceptionalistByLastName(lastName);
	}


	@Override
	public List<Receptionalist> getReceptionalistByCity(String City) {
				return receptionalistRepository.findReceptionalistByCity(City);
	}
	
	/*@Override
	public List<Receptionalist> getReceptionalistByFirstNameAndLastName(String firstName, String lastName) {
		return receptionalistRepository.findReceptionalistByFirstNameAndLastName(firstName, lastName);
	}*/

}
