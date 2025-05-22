package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;
import com.luv2code.cruddemo.dao.AppDAO;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor Detail with id = " + theId);
		InstructorDetail instructorDetailTemp = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Detail = " + instructorDetailTemp);
		System.out.println("Associated Instructor: " + instructorDetailTemp.getInstructor());
		System.out.println("I'm done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Delete instructor with id " + theId);
		appDAO.deleteById(2);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;

		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("The associated instructorDetail only " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
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
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
