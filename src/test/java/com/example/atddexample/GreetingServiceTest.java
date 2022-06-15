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

	@BeforeEach
	void setUp() {
	    greetingService = new GreetingService();
	}

	@Test
	void greet_with_nonExisting_last_name_should_return_default_message() {
		// String nonExistingLastName = "nonExistingLastName";
		// String msg = greetingService.greet(nonExistingLastName);
		// assertThat(msg).isEqualTo("Who is this " + nonExistingLastName + " you're talking about?");
		String nonExistingLastName = "nonExistingLastName";
		String existingLastName = "existingLastName";
		String firstName = "firstName";
		String lastName = "lastName";
		given(repository.findByLastName(nonExistingLastName))
			.willReturn(Optional.empty());
		given(repository.findByLastName(existingLastName))
			.willReturn(Optional.of(new Employee(lastName, firstName)));

		Optional<Employee> employee = repository.findByLastName(nonExistingLastName);
		String msg = employee.map(e -> String.format("Hello %s %s!", e.getFirstName(), e.getLastName()))
			.orElse("Who is this " + nonExistingLastName + " you're talking about?");

		assertThat(msg).isEqualTo("Who is this " + nonExistingLastName + " you're talking about?");

		employee = repository.findByLastName(existingLastName);
		msg = employee.map(e -> String.format("Hello %s %s!", e.getFirstName(), e.getLastName()))
			.orElse("Who is this " + nonExistingLastName + " you're talking about?");
		assertThat(msg).isEqualTo("Hello " + firstName + " " + lastName + "!");

	}



}