package com.example.atddexample;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GreetingService {

	private final EmployeeRepository repository;

	public String greet(String lastName) {
		return repository.findByLastName(lastName)
			.map(e -> String.format("Hello %s %s!", e.getFirstName(), e.getLastName()))
			.orElse("Who is this " + lastName + " you're talking about?");
	}
}
