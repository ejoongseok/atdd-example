package com.example.atddexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
	private final GreetingService greetingService;

	@GetMapping("/hello/{lastName}")
	public String greeting(@PathVariable String lastName) {
		return greetingService.greet(lastName);
	}
}
