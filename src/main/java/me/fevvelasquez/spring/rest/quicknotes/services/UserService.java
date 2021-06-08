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
 * @version 0.0.4. Update user, @PutMapping
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
		for (int id = 1; id < 10; id++) {
			users.add(new User(id, faker.avatar().image(), faker.name().fullName()));
		}
	}

	/**
	 * List of All Users.
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Find User by Id.
	 */
	public User getUserById(Integer id) {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id=%d, Not Found", id)));
	}

	/**
	 * Create User.
	 */
	public User createUser(User user) {
		// Lets suppose there are no duplicates generated by faker!
		if (users.stream().anyMatch(u -> u.getName().equals(user.getName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User with name=%s, Already exists", user.getName()));
		}

		User newUser = new User(users.size() + 1, user.getAvatar(), user.getName());
		users.add(newUser);
		return newUser;
	}

	/**
	 * Update User
	 */
	public User updateUser(Integer id, User user) {
		User newUser = new User(id, user.getAvatar(), user.getName());
		User userToBeUpdated = getUserById(id);
		if (users.remove(userToBeUpdated)) {
			users.add(newUser);
		}
		return newUser;
	}

}
