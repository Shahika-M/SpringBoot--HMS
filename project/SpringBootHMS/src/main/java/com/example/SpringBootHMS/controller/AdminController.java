package com.example.SpringBootHMS.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootHMS.entity.Admin;
import com.example.SpringBootHMS.entity.Patient;
import com.example.SpringBootHMS.service.AdminService;

@RestController
@RequestMapping("/api/admin")

public class AdminController {
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@GetMapping
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Admin>getAdminById(@PathVariable("id") int id) {
		return new ResponseEntity<Admin>(adminService.getAdminById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin){
		
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") int id){
		adminService.deleteAdmin(id);
		return new ResponseEntity<String>("Admin record deleted ",HttpStatus.OK);
		
	}

}
