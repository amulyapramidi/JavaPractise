package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.MainController;

@ComponentScan(basePackageClasses=MainController.class)
@SpringBootApplication
public class MyFirstSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringProjectApplication.class, args);
	}

}

