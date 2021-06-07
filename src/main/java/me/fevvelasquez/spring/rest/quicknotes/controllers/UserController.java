package me.fevvelasquez.spring.rest.quicknotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.fevvelasquez.spring.rest.quicknotes.models.User;
import me.fevvelasquez.spring.rest.quicknotes.services.UserService;

/**
 * UserController
 * 
 * @version 0.0.1. Introducing ResponseEntity, @@RestController, @@RequestMapping
 * @author fevvelasquez@gmail.com
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> get() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}

}
