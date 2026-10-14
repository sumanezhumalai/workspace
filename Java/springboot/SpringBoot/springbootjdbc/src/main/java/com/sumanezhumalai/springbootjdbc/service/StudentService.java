package com.sumanezhumalai.springbootjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumanezhumalai.springbootjdbc.model.Student;
import com.sumanezhumalai.springbootjdbc.repository.StudentRepository;

@Service
public class StudentService {

    private final Student student;
    private final StudentRepository repo;

    StudentService(@Autowired StudentRepository repo, Student student) {
        this.repo = repo;
        this.student = student;
    }

    public void addStudent(Student newStudent) {
        int status = repo.save(newStudent); // we are using JPA method name conventions for consistent learning
        if (status > 0)
            System.out.println("Student added Successfully");
        else
            System.out.println("Student addition has failed !");
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
