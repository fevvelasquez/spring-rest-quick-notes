package me.fevvelasquez.spring.rest.quicknotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.fevvelasquez.spring.rest.quicknotes.models.User;
import me.fevvelasquez.spring.rest.quicknotes.services.UserService;

/**
 * UserController
 * 
 * @version 0.0.6. Query params user, @RequestParam
 * @author fevvelasquez@gmail.com
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Get list of users which contains a given string.
	 * 
	 * e.g. "/users?contains=s"
	 */
	@GetMapping
	public ResponseEntity<List<User>> getUsers(
			@RequestParam(value = "contains", required = false) String contains) {
		return new ResponseEntity<List<User>>(userService.getUsers(contains), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	/**
	 * Creates a User.
	 * 
	 * @param user in JSON format. e.g. { "avatar":"https://example/128.jpg","name":
	 *             "Juan" }
	 * @return new user with id generated.
	 */
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	/**
	 * Update User.
	 * 
	 * @param id
	 * @param user in JSON format with the new data
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
