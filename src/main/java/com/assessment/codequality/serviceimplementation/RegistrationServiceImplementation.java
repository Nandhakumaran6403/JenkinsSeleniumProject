package com.assessment.codequality.serviceimplementation;

import java.util.List;
import org.springframework.stereotype.Service;

import com.assessment.codequality.model.Registration;
import com.assessment.codequality.repository.RegistrationRepository;
import com.assessment.codequality.service.RegistrationService;


@Service
public class RegistrationServiceImplementation implements RegistrationService {

	RegistrationRepository repo;

	public RegistrationServiceImplementation(RegistrationRepository repo) {
		super();
		this.repo = repo;
	}

	public String addRegistration(Registration rn) {
		  
		if(rn!=null) {
			 repo.saveRegistration(rn);
			 return "success";
		}
		else
		{
			return "failure";
		}
	}

	@Override
	public Registration getRegistration(int id) {
		if(repo.findRegistrationById(id) != null) {
		 return repo.findRegistrationById(id);
		}
		return null;
		
	}

	public List<Registration> getAllRegistration() {
		return repo.findAllRegistration();
	}

	public String updateRegistration(Registration rn) {
		if(rn != null) {
			repo.updateRegistrationById(rn);
			return "success";
		}
		else {
			return "failure";
		}
		 
	}

	public String deleteRegistrationById(int id) {
		if(repo.findRegistrationById(id) != null) {
			repo.deleteRegistration(id);
			return "success";
		}
		else {
			return "failure";
		}
			
	}
}
