package com.assessment.codequality.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.codequality.model.Registration;
import com.assessment.codequality.service.RegistrationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:3001,http://localhost:3000,http://localhost:3002,http://localhost:3003")
@RestController
@RequestMapping("/registration")
public class RegistrationController {

	RegistrationService service;

	public RegistrationController(RegistrationService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public void insertRegistration(@RequestBody Registration rn) {

		 service.addRegistration(rn);
	}

	@GetMapping("{id}")
	public String getRegistrationById(@PathVariable("id") int id) {
		if(service.getRegistration(id)!=null) {
			service.getRegistration(id);
			return "success";
		}
		else {
			return "failure";
		}
		
	}

	@GetMapping("/all")
	public List<Registration> viewAllRegistration() {
		return service.getAllRegistration();
	}

	@PutMapping
	public void updateRegistration(@RequestBody Registration rn) {

		 service.updateRegistration(rn);
	}

	@DeleteMapping("{id}")
	public void deleteRegistrationById(@PathVariable("id") int id) {

		service.deleteRegistrationById(id);
	}
}
