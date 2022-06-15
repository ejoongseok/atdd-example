package com.example.atddexample;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.hamcrest.MockitoHamcrest;

class GreetingServiceTest {
	private GreetingService greetingService;

	@BeforeEach
	void setUp() {
	    greetingService = new GreetingService();
	}

	@Test
	void greet_with_nonExisting_last_name_should_return_default_message() {
		// given
		String nonExistingLastName = "nonExistingLastName";
		// when
		String msg = greetingService.greet(nonExistingLastName);
		// then
		assertThat(msg).isEqualTo("Who is this " + nonExistingLastName + " you're talking about?");
	}



}