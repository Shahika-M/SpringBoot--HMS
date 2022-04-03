
package com.example.SpringBootHMS;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringBootHMS.entity.Doctor;
import com.example.SpringBootHMS.entity.Patient;
import com.example.SpringBootHMS.service.DoctorService;
import com.example.SpringBootHMS.service.PatientService;
//import com.example.SpringBootHMS.service.ProjectsService;

@Controller
public class UIController {
	
	private PatientService patientService;
       private DoctorService doctorService;
	//private ProjectsService projectService;
	
	
@Autowired	
public UIController(PatientService patientService,DoctorService doctorService) {
		super();
		this.patientService = patientService;
	this.doctorService = doctorService;
		//this.projectService = projectService;
	}

@GetMapping("/gotopatient")

String pat() {
	return "next-pageP";
}

@GetMapping("/gotoadminpatient")

String admP() {
	return "next-pagepatient";
}

@GetMapping("/gotoadmindoctor")

String admD() {
	return "next-pagedoctor";
}

@GetMapping("/gotodoctor")

String doc() {
	return "next-pageD";
}

@GetMapping("/")
	
	String index() {
		return "index";/// index.html
	}


@GetMapping("/registration")
public String empRegistrationForm(Model model) {
	Patient patient = new Patient();
	model.addAttribute("patient", patient);
    return "add-patient";
}

@PostMapping("/savePatient")
public String savePatient(@Validated  Patient patient, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    patientService.savePatient(patient);
	List<Patient> patientt=  patientService.getAllPatient();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getPatients";
    
}

@GetMapping("/getPatients")
public String getAllPatient(Model model) {
	
	List<Patient> patients =  patientService.getAllPatient();
	
	model.addAttribute("patients", patients);
	
    return "list-patient";
    }

@GetMapping("/updateFormPatient/{id}")
public String updateFormPatient(@PathVariable(value="id") int id,Model model) {
	Patient patient=patientService.getPatientById(id);
	model.addAttribute("patient",patient);
	return "update-patient";
	
}


@PostMapping("/updatePatient")
public String updatePatient(@PathVariable(value="id") int id,@ModelAttribute Patient patient,Model model) {
	patientService.updatePatient(patient, id);
	model.addAttribute("message","record updated successfully");
	getAllPatient(model);
	return null;
	}


// Doctor

@GetMapping("/docRegister")
public String docRegistrationForm(Model model) {
	Doctor doctor = new Doctor();
	model.addAttribute("doctor", doctor);
    return "add-doctor";
}

@PostMapping("/saveDoctor")
public String addDoc(@Validated  Doctor doctor, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "add-doctor";
	else {
    doctorService.saveDoctor(doctor);
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "list-doctor";
}
    @GetMapping("/getDoctors")
    public String getAllDoctor(Model model) {
    	
    	List<Doctor> doctors =  doctorService.getAllDoctor();
    	
    	model.addAttribute("doctors", doctors);
    	
        return "list-doctor";
        } 
    
}

