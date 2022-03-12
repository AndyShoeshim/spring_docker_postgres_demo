package com.movenda.springdemo.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // hibernate framework
@Table // db
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;

    @Transient
    private int age;
    private LocalDate dateOfBirth;

    public Student() {
	// TODO Auto-generated constructor stub
    }

    public Student(String name, String email, LocalDate dateOfBirth) {
	this.name = name;
	this.email = email;
	this.age = age;
	this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public int getAge() {
	return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
	this.age = age;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

}
