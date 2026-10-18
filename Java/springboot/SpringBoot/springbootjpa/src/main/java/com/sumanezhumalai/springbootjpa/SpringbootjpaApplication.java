package com.sumanezhumalai.springbootjpa;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sumanezhumalai.springbootjpa.model.Student;
import com.sumanezhumalai.springbootjpa.repository.StudentRepository;

@SpringBootApplication
public class SpringbootjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjpaApplication.class, args);

		final StudentRepository repo = context.getBean(StudentRepository.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollNo(1);
		s1.setName("Suman");
		s1.setCgpa(7);

		s2.setRollNo(2);
		s2.setName("Shyam");
		s2.setCgpa(9);

		s3.setRollNo(3);
		s3.setName("Sundar");
		s3.setCgpa(8);

		// Insert
		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

		// Select & Search
		// System.out.println(repo.findAll());
		// System.out.println(repo.findById(1));

		// Optional<Student> s = repo.findById(101);
		// System.err.println(s.orElse(new Student()));

		// Custom Endpoints
		// System.out.println(repo.findByName("Suman"));
		// System.out.println(repo.findByCgpa(7));
		// System.out.println(repo.findByCgpaGreaterThan(7));

		// Update
		s2.setCgpa(10);
		repo.save(s2); // looks for the record if exists update, if not inserts
		System.out.println(repo.findById(s2.getRollNo()));

		// delete
		repo.delete(s3);
		System.out.println(repo.findAll());
	}

}
