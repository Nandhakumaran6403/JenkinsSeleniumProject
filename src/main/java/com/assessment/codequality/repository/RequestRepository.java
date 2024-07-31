package com.assessment.codequality.repository;

import java.util.List;

import com.assessment.codequality.model.Request;

public interface RequestRepository {

	Request findRequestById(int id);

	void saveRequest(Request request);

	void deleteRequest(int id);

	void updateRequest(Request equest);

	List<Request> findAllRequests();

}
