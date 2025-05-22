package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;
import com.luv2code.cruddemo.dao.InstructorDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
//			createInstructor(instructorDAO);
//			findInstructor(instructorDAO);
			deleteInstructor(instructorDAO);
		};
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int theId = 2;
		System.out.println("Delete instructor with id " + theId);
		instructorDAO.deleteById(2);
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		int theId = 1;

		Instructor tempInstructor = instructorDAO.findById(theId);
		System.out.println("The associated instructorDetail only " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(InstructorDAO instructorDAO) {
//		Instructor tempInstructor =
//				new Instructor("Chad", "Darby", "darby@luv2code.com");
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("youtube.com/lub2code", "love to code!!");

		Instructor tempInstructor =
				new Instructor("Nghia", "Le", " nghiale@luv2code.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("youtube.com/ihavenoidea", "maybe love to code!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor " + tempInstructor);
		instructorDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
