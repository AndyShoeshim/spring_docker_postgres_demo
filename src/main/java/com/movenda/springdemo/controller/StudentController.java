package com.movenda.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movenda.springdemo.model.Student;
import com.movenda.springdemo.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
	this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
	return studentService.getStudents();
    }

    @PostMapping
    public void insertStudent(@RequestBody Student student) {
	studentService.insertStudent(student);
    }

    @DeleteMapping(path = "/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
	studentService.deleteById(studentId);
    }

    @PutMapping(path = "update/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam("email") String email) {
	studentService.updateStudent(studentId, email);
    }
}
