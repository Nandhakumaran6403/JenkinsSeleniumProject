package com.assessment.codequality.repositoryimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assessment.codequality.model.Request;
import com.assessment.codequality.repository.RequestRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RequestRepositoryImplementation implements RequestRepository {

	@Autowired
	EntityManager eManager;

	@Override
	public void saveRequest(Request request) {
		eManager.merge(request);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Request> findAllRequests() {
		String hql = "select r from Request r order by requestId";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Request findRequestById(int id) {
		return eManager.find(Request.class, id);
	}

	@Override
	public void updateRequest(Request request) {
		eManager.merge(request);
	}

	@Override
	public void deleteRequest(int id) {
		Request requestToDelete = findRequestById(id);
		if (requestToDelete != null) {
			eManager.remove(requestToDelete);
		}
	}

}
