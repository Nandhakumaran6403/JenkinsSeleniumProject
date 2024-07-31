package com.assessment.codequality.repositoryimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assessment.codequality.model.User;
import com.assessment.codequality.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImplementation implements UserRepository {

	@Autowired
	EntityManager eManager;

	public void saveUser(User user) {
		eManager.persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		String hql = "from User";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public User findUserById(int id) {
		return eManager.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		eManager.merge(user);
	}

	@Override
	public void deleteUser(int id) {
		User userToDelete = findUserById(id);
		if (userToDelete != null) {
			eManager.remove(userToDelete);
		}
	}
	
	@Override
	public User find() {
		String hql = "SELECT u FROM User u ORDER BY id DESC LIMIT 1";
		return (User) eManager.createQuery(hql).getSingleResult();
	}

}
