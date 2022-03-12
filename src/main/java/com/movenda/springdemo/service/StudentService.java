package com.movenda.springdemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movenda.springdemo.model.Student;
import com.movenda.springdemo.repository.StudentRepository;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
	this.studentRepository = studentRepository;
    }

    public java.util.List<Student> getStudents() {
	return studentRepository.findAll();
    }

    public void insertStudent(Student student) {
	Optional<Student> retriviedStudent = studentRepository.findStudentByEmail(student.getEmail());
	if (retriviedStudent.isEmpty())
	    studentRepository.save(student);
	else
	    throw new IllegalArgumentException("Email alreday taken!");
    }

    public void deleteAll() {
	studentRepository.deleteAll();
    }

    public void deleteById(Long studentId) {
	studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String email) {
	Optional<Student> student = studentRepository.findById(studentId);
	if (!student.isPresent())
	    throw new IllegalArgumentException("User not exists!");
	else
	    student.get().setEmail(email);
    }
}
