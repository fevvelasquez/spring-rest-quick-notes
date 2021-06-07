package me.fevvelasquez.spring.rest.quicknotes.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import me.fevvelasquez.spring.rest.quicknotes.models.User;

/**
 * UserService.
 * 
 * @version 0.0.1. Introducing ResponseEntity, @@RestController, @@RequestMapping
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
			users.add(new User(id, faker.company().logo(), faker.name().fullName()));
		}
	}

	public List<User> getUsers() {
		return users;
	}

}
