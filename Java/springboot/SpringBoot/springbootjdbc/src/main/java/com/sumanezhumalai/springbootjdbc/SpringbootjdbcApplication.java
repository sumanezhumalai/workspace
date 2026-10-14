package com.sumanezhumalai.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sumanezhumalai.springbootjdbc.model.Student;
import com.sumanezhumalai.springbootjdbc.service.StudentService;

@SpringBootApplication
public class SpringbootjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjdbcApplication.class, args);

		StudentService service = context.getBean(StudentService.class);

		Student suman = context.getBean(Student.class);
		suman.setId(6);
		suman.setAge(21);
		suman.setName("Suman");

		service.addStudent(suman);
		System.out.println(service.getAllStudents());
	}

}
