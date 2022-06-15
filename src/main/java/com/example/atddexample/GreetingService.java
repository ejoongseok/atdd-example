package com.example.atddexample;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
public class GreetingService {
	public String greet(String lastName) {
		return "Who is this " + lastName + " you're talking about?";
	}
}
