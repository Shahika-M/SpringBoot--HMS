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

import com.example.SpringBootHMS.entity.Doctor;
import com.example.SpringBootHMS.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")

public class DoctorController {
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Doctor> getAllDoctor()
	{
		return doctorService.getAllDoctor();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Doctor>getDoctorById(@PathVariable("id") int id) {
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") int id, @RequestBody Doctor doctor){
		
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") int id){
		doctorService.deleteDoctor(id);
		return new ResponseEntity<String>("Doctor record deleted ",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/doctorByFirstName/{firstName}")
	public List<Doctor> getDoctorByFirstName(@PathVariable("firstName")String firstName){
		return doctorService.getDoctorByFirstName(firstName);//john
	}
	
	@GetMapping("/doctorByCity/{city}")
	public List<Doctor> getDoctorByCity(@PathVariable("city") String city){
		return doctorService.getDoctorByCity(city);
		
	}
	
	@GetMapping("/doctorBySpecialization/{specialization}")
	public List<Doctor> getDoctorBySpecialization(@PathVariable("specialization") String specialization){
		return doctorService.getDoctorBySpecialization(specialization);
		
	}
	
	/*	@GetMapping("/doctorByFirstNameAndLastName")
	public List<Doctor> getPatientByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return doctorService.getDoctorByFirstNameAndLastName(firstName, lastName);
		
	}*/
	

	/*@GetMapping("/doctorByFirstNameOrLastName")
	public List<Doctor> getDoctorByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return doctorService.getDoctorByFirstNameOrLastName(firstName, lastName);
		
	}
	
	@GetMapping("/doctorByIds")
	public List<Doctor> getDoctorByIds(@RequestParam(value="id") List<int> id){
		return  doctorService.getDoctorById(id);
	}
	
	@GetMapping("/doctorByDepartment/{id}")
	public List<Doctor> getDoctorByDepartment(@PathVariable("id") int id){
		return Service.getDoctorByDepartment(id);
		
	}
	
	@GetMapping("/doctortByDepartmentGroup")
	public List<Doctor> getDoctorByDepartmentGroup(){
		return doctorService.getDoctorByDepartmentGroup();
	}
	
	@GetMapping("/doctorFullNameById/{id}")
	public Doctor getDoctorFullNameById( @PathVariable("id") int id){
		return doctorService.getDoctorFullNameById(id);
	}
	
		
		
	@GetMapping("/DoctorInDescOrder")
	public List<Doctor> getDoctorInDescOrder(){
		return DoctorService.getDoctorInDescOrder();
	}

	*/
	
	
	
	


}



