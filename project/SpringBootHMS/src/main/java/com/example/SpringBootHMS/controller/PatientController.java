package com.example.SpringBootHMS.controller;



import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.Controller;

import com.example.SpringBootHMS.entity.Patient;
import com.example.SpringBootHMS.service.PatientService;

@RestController
@RequestMapping("/api/patient")
//@Controller
public class PatientController {
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Patient> getAllPatient()
	{
		return patientService.getAllPatient();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable("id") int id) {
		return new ResponseEntity<Patient>(patientService.getPatientById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id, @RequestBody Patient patient){
		
		return new ResponseEntity<Patient>(patientService.updatePatient(patient, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		patientService.deletePatient(id);
		return new ResponseEntity<String>("Patient record deleted ",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/patientByFirstName/{firstName}")
	public List<Patient> getPatientByFirstName(@PathVariable("firstName")String firstName){
		return patientService.getPatientByFirstName(firstName);
	}
	
	@GetMapping("/patientByLastName/{lastName}")
	public List<Patient> getPatientByLastName(@PathVariable("lastName") String lastName){
		return patientService.getPatientByLastName(lastName);
		
	}
	
/*	@GetMapping("/doctorById/{id}")
	public List<Patient> getDoctorById(@PathVariable("id") int id){
		return patientService.getPatientByDoctor(id);
		
	}*/
	
		@GetMapping("/patientByFirstNameAndLastName")
	public List<Patient> getPatientByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return patientService.getPatientByFirstNameAndLastName(firstName, lastName);
		
	}
	

	/*@GetMapping("/patientByFirstNameOrLastName")
	public List<Patient> getPatientByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return patientService.getPatientByFirstNameOrLastName(firstName, lastName);
		
	}
	
	@GetMapping("/patientByIds")
	public List<Patient> getPatientByIds(@RequestParam(value="id") List<Long> id){
		return  patientService.getPatientById(id);
	}
	
	@GetMapping("/employeeByDepartment/{id}")
	public List<Employee> getemployeeByDepartment(@PathVariable("id") Long id){
		return Service.getEmployeeByDepartment(id);
		
	}
	
	@GetMapping("/patientByDepartmentGroup")
	public List<Patient> getPatientByDepartmentGroup(){
		return patientService.getPatientByDepartmentGroup();
	}
	
	@GetMapping("/patientFullNameById/{id}")
	public Patient getPatientFullNameById( @PathVariable("id") int id){
		return patientService.getPatientFullNameById(id);
	}
	
		
		
	@GetMapping("/PatientInDescOrder")
	public List<Patient> getPatientInDescOrder(){
		return patientService.getPatientInDescOrder();
	}

	*/
		
		
	
	
	
	


}
