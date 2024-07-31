package com.assessment.codequality.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment.codequality.model.Request;
import com.assessment.codequality.repository.RequestRepository;
import com.assessment.codequality.service.RequestService;

@Service
public class RequestServiceImplementation implements RequestService {

	private final RequestRepository requestRepo;

	public RequestServiceImplementation(RequestRepository requestRepo) {
		this.requestRepo = requestRepo;
	}

	@Override
	public String saveAddRequest(Request request) {

		if (request != null) {
			requestRepo.saveRequest(request);
			return "success";
		} else {
			return "failure";
		}
	}

	@Override
	public Request getRequestById(int id) {

			
			return requestRepo.findRequestById(id);
			

	}

	public List<Request> getAllRequests() {

		return requestRepo.findAllRequests();
	}

	@Override
	public void updateIdRequest(Request request) {

//		if (request != null) {
//			requestRepo.updateRequest(request);
//			return "success";
//		} else {
//			return "failure";
//		}
		 requestRepo.updateRequest(request);
		

	}

	@Override
	public String deleteIdRequest(int id) {

		if (requestRepo.findRequestById(id) != null) {
			requestRepo.deleteRequest(id);
			return "success";
		} else {
			return "failure";
		}
	}

}
