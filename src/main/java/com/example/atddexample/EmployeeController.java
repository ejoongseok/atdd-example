package com.example.atddexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private GreetingService greetingService;

	@GetMapping("/hello/{lastName}")
	public String greeting(@PathVariable String lastName) {
		return greetingService.greet(lastName);
	}
}
