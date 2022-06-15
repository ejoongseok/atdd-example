package com.example.atddexample;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {
	private GreetingService greetingService;
	@Mock EmployeeRepository repository;
	String nonExistingLastName = "nonExistingLastName";
	String existingLastName = "existingLastName";
	String firstName = "firstName";
	String lastName = "lastName";

	@BeforeEach
	void setUp() {
	    greetingService = new GreetingService();
		greetingService.repository = repository;
	}

	@Test
	void greet_with_nonExisting_last_name_should_return_default_message() {
		given(repository.findByLastName(nonExistingLastName))
			.willReturn(Optional.empty());
		String msg = greetingService.greet(nonExistingLastName);
		assertThat(msg).isEqualTo("Who is this " + nonExistingLastName + " you're talking about?");
	}

	@Test
	void greet_with_existing_last_name_should_return_hello_message_with_appropriate_names() {
		given(repository.findByLastName(existingLastName))
			.willReturn(Optional.of(new Employee(lastName, firstName)));
		String msg = greetingService.greet(existingLastName);
		assertThat(msg).isEqualTo("Hello " + firstName + " " + lastName + "!");
	}


}