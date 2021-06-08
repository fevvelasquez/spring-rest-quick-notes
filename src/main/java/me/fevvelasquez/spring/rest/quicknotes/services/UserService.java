package me.fevvelasquez.spring.rest.quicknotes.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;

import me.fevvelasquez.spring.rest.quicknotes.models.User;

/**
 * UserService.
 * 
 * @version 0.0.2. Get User by Id, @PathVariable
 * @author fevvelasquez@gmail.com
 *
 */
@Service
public class UserService {
	@Autowired
	private Faker faker;

	private List<User> users = new ArrayList<>();

	@PostConstruct
	private void init() {
		for (int id = 1; id < 100; id++) {
			users.add(new User(id, faker.avatar().image(), faker.name().fullName()));
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public User getUserById(Integer id) {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id=%d, Not Found", id)));
	}

}
