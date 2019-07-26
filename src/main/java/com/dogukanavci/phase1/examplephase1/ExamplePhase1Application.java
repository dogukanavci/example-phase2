package com.dogukanavci.phase1.examplephase1;

import com.dogukanavci.phase1.examplephase1.Entity.Designation;
import com.dogukanavci.phase1.examplephase1.Entity.Employee;
import com.dogukanavci.phase1.examplephase1.Repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ExamplePhase1Application {

	public static void main(String[] args) {
		SpringApplication.run(ExamplePhase1Application.class, args);
	}
}
