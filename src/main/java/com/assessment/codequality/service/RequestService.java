package com.assessment.codequality.service;

import java.util.List;
import com.assessment.codequality.model.Request;

public interface RequestService {

	Request getRequestById(int id);

	String saveAddRequest(Request request);

	String deleteIdRequest(int id);

	void updateIdRequest(Request request);

	List<Request> getAllRequests();

}
