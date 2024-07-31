package com.assessment.codequality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.assessment.codequality.model.Request;
import com.assessment.codequality.service.RequestService;

import java.util.List;

@CrossOrigin("http://localhost:3001,http://localhost:3000, http://localhost:3002,http://localhost:3003")
@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired
	private RequestService requestService;

	@GetMapping("/all")
	public List<Request> getAllDonationRequests() {
		return requestService.getAllRequests();

	}

	@GetMapping("/{id}")
	public Request getRequestById(@PathVariable int id) {
			return requestService.getRequestById(id);
	}

	@PostMapping
	public void addRequest(@RequestBody Request request) {
		requestService.saveAddRequest(request);
	}

	@PutMapping("/{id}")
	public void updatetheRequest(@RequestBody Request request) {
		requestService.updateIdRequest(request);
	}

	@DeleteMapping("/{id}")
	public void deleteRequest(@PathVariable("id") int id) {
		requestService.deleteIdRequest(id);
	}
}
