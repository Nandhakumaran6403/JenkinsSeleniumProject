package com.assessment.codequality.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.assessment.codequality.model.Registration;

@Repository
public interface RegistrationRepository {

	Registration findRegistrationById(int id);

	void saveRegistration(Registration registration);

	void deleteRegistration(int id);

	void updateRegistrationById(Registration registration);

	List<Registration> findAllRegistration();
}
