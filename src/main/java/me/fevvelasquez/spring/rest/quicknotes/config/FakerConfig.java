package me.fevvelasquez.spring.rest.quicknotes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * Explicit bean definition to Faker.
 * 
 * See: https://github.com/DiUS/java-faker
 * 
 * @version 0.0.1. Introducing ResponseEntity, @@RestController, @@RequestMapping
 * @author fevvelasquez@gmail.com
 *
 */
@Configuration
public class FakerConfig {

	@Bean
	public Faker getFaker() {
		return new Faker();
	}

}
