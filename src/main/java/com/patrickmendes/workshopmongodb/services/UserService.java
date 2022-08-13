package com.patrickmendes.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrickmendes.workshopmongodb.domain.User;
import com.patrickmendes.workshopmongodb.repository.UserRepository;
import com.patrickmendes.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		User user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
