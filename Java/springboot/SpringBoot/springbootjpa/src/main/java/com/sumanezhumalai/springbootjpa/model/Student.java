package com.sumanezhumalai.springbootjpa.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@Scope("prototype")
public class Student {
    @Id
    private int rollNo;
    private String name;
    private int cgpa;
}
