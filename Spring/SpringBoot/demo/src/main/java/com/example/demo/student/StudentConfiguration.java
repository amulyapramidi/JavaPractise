package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
        Student amulya = new Student(1, "Amulya", LocalDate.of(1994, Month.MARCH,18),"amulyapramidi@gmail.com");
        Student nagarjuna = new Student(2, "Nagarjuna", LocalDate.of(1990, Month.FEBRUARY,18),"nagarjuna149@gmail.com");
        Student amma = new Student(3,"Amma" ,LocalDate.of(1967, Month.FEBRUARY,18),"vanamlakshmi@gmail.com");

        studentRepository.saveAll(List.of(amulya,nagarjuna,amma));

    };
    };
}
