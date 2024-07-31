package com.assessment.codequality.repository;

import java.util.List;

import com.assessment.codequality.model.User;
public interface UserRepository {

	User findUserById(int id);

	void saveUser(User user);

	void deleteUser(int id);

	void updateUser(User user);

	List<User> findAllUsers();

	User find();

}
