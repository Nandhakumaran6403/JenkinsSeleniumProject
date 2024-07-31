package com.assessment.codequality.service;

import java.util.List;

import com.assessment.codequality.model.Registration;

public interface RegistrationService {

	public String addRegistration(Registration rn);

	public Registration getRegistration(int id);

	public List<Registration> getAllRegistration();

	public String updateRegistration(Registration rn);

	public String deleteRegistrationById(int id);
}
