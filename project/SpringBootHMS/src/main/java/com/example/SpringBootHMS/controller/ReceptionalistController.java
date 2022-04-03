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

import com.example.SpringBootHMS.entity.Receptionalist;
import com.example.SpringBootHMS.service.ReceptionalistService;

@RestController
@RequestMapping("/api/receptionalist")

public class ReceptionalistController {
	private ReceptionalistService receptionalistService;

	public ReceptionalistController(ReceptionalistService receptionalistService) {
		super();
		this.receptionalistService = receptionalistService;
	}
	
	@PostMapping
	public ResponseEntity<Receptionalist> saveReceptionalist(@RequestBody Receptionalist receptionalist) {
		return new ResponseEntity<Receptionalist>(receptionalistService.saveReceptionalist(receptionalist),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Receptionalist> getAllReceptionalist()
	{
		return receptionalistService.getAllReceptionalist();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Receptionalist>getReceptionalistById(@PathVariable("id") int id) {
		return new ResponseEntity<Receptionalist>(receptionalistService.getReceptionalistById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Receptionalist> updateReceptionalist(@PathVariable("id") int id, @RequestBody Receptionalist receptionalist){
		
		return new ResponseEntity<Receptionalist>(receptionalistService.updateReceptionalist(receptionalist, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteReceptionalist(@PathVariable("id") int id){
		receptionalistService.deleteReceptionalist(id);
		return new ResponseEntity<String>("Receptionalist record deleted ",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/receptionalistByFirstName/{firstName}")
	public List<Receptionalist> getReceptionalistByFirstName(@PathVariable("firstName")String firstName){
		return receptionalistService.getReceptionalistByFirstName(firstName);//john
	}
	
	@GetMapping("/receptionalistByLastName/{lastName}")
	public List<Receptionalist> getReceptionalistByLastName(@PathVariable("lastName") String lastName){
		return receptionalistService.getReceptionalistByLastName(lastName);
		
	}
	
		/*@GetMapping("/receptionalistByFirstNameAndLastName")
	public List<Receptionalist> getReceptionalistByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return receptionalistService.getReceptionalistByFirstNameAndLastName(firstName, lastName);
		
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








