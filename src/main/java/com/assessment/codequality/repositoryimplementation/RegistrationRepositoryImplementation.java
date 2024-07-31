package com.assessment.codequality.repositoryimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.assessment.codequality.model.Registration;
import com.assessment.codequality.repository.RegistrationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RegistrationRepositoryImplementation implements RegistrationRepository {

	@Autowired
	EntityManager eManager;

	@Override
	public void saveRegistration(Registration registration) {
		 eManager.persist(registration);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> findAllRegistration() {
		String hql = "from Registration";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Registration findRegistrationById(int id) {
		return eManager.find(Registration.class, id);
	}

	@Override
	public void updateRegistrationById(Registration registration) {
		 eManager.merge(registration);
	}

	@Override
	public void deleteRegistration(int id) {
		Registration registrationToDelete = findRegistrationById(id);
		if (registrationToDelete != null) {
			eManager.remove(registrationToDelete);
		}
	}

}
