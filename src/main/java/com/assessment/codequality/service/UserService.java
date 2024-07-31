package com.assessment.codequality.service;

import java.util.List;

import com.assessment.codequality.model.User;


public interface UserService {

	User getUserById(int id);

	String saveAddUser(User user);

	String deleteIdUser(int id);

	String updateIdUser(User user);

	List<User> getAllUsers();

	User getUserFind();
}
