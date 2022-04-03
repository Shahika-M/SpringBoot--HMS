package com.example.SpringBootHMS.serviceImpl;

import java.util.*;

import org.springframework.stereotype.Service;
import com.example.SpringBootHMS.entity.Admin;
import com.example.SpringBootHMS.entity.Patient;
import com.example.SpringBootHMS.exception.ResourceNotFound;

import com.example.SpringBootHMS.repository.AdminRepository;

import com.example.SpringBootHMS.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
private AdminRepository adminRepository;
	
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
		
	}

	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> admin = adminRepository.findById(id);//4
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
          
			throw new ResourceNotFound("admin","Id",id);
		}
		
	}


	@Override
	public Admin updateAdmin(Admin admin, int id) {
		Admin a = new Admin();
	 try {
		
		   a = adminRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Patient","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 
	
	 a.setUsername(admin.getUsername());
	 a.setPwd(admin.getPwd());
	
	 adminRepository.save(a);
	return a;
	}
	
	@Override
	public void deleteAdmin(int id) {
		
		adminRepository.findById(id).orElseThrow(
				()->new ResourceNotFound("Admin","Id",id));
		adminRepository.deleteById(id);
		
	}
	


}
