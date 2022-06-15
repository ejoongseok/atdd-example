package com.example.atddexample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "employees")
@Getter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String lastName;
	private String firstName;

	public Employee() {
	}

	public Employee(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
}
