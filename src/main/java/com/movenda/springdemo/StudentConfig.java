package com.movenda.springdemo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.movenda.springdemo.model.Student;
import com.movenda.springdemo.repository.StudentRepository;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
	return args -> {
	    Student andreaStudent = new Student("Andrea", "andrea@gmail.com", LocalDate.of(1998, 11, 12));
	    Student salvatoreStudent = new Student("Salvatore", "pukino@gmail.com", LocalDate.of(1998, 8, 17));

	    studentRepository.saveAll(List.of(andreaStudent, salvatoreStudent));
	};
    }
}
