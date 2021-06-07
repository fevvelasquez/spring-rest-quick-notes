package me.fevvelasquez.spring.rest.quicknotes.models;

/**
 * User
 * 
 * @version 0.0.1. Introducing ResponseEntity, @@RestController, @@RequestMapping
 * @author fevvelasquez@gmail.com
 *
 */
public class User {
	private final Integer id;
	private final String avatar;
	private final String name;

	public User(Integer id, String avatar, String name) {
		this.id = id;
		this.avatar = avatar;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", avatar=" + avatar + ", name=" + name + "]";
	}

}
