package com.example.atddexample;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.restassured.specification.RequestSpecification;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
	classes = EmployeeApplication.class
)
class EmployeeControllerRestAssuredIntegrationTest {
	@Autowired
	EmployeeRepository repository;

	RequestSpecification basicRequest;

	@BeforeEach
	void setUp() {
		basicRequest = given()
			.baseUri("http://localhost")
			.port(8080)
		;

		repository.deleteAll();
		repository.save(new Employee("Baek", "Myeongseok"));
	}

	@Test
	void shouldReturnDefaultMessageWhenLastNameNotFound() {
		String nonExistingLastName = "nonExistingLastName";
		String expectedMessage = "Who is this " + nonExistingLastName + " you're talking about?";

		given().spec(basicRequest).basePath("/api/hello/" + nonExistingLastName)
			.when().get()
			.then().log().body()
			.statusCode(HttpStatus.OK.value())
			.body(is(expectedMessage));
	}

	@Test
	void shouldReturnGreetingMessageWhenLastNameFound() {
		String existingLastName = "Baek";
		String expectedMessage = "Hello Myeongseok Baek!";

		given().spec(basicRequest).basePath("/api/hello/" + existingLastName)
			.when().get()
			.then().log().body()
			.statusCode(HttpStatus.OK.value())
			.body(is(expectedMessage));
	}
}
