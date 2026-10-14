package com.sumanezhumalai.springbootjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sumanezhumalai.springbootjdbc.model.Student;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    StudentRepository(@Autowired JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public int save(Student student) {
        String sql = "insert into student (id, name, age) values (?,?,?)";
        return jdbc.update(sql, student.getId(), student.getName(), student.getAge()); // return number of row affected
    }

    public List<Student> findAll() {
        String sql = "Select * from student";

        // RowMapper<Student> mapper = new RowMapper<>() {
        // @Override
        // public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Student student = new Student();
        // student.setId(rs.getInt("id"));
        // student.setName(rs.getString("name"));
        // student.setAge(rs.getInt("age"));

        // return student;
        // }
        // };

        // Lambda Expression
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));

            return student;
        };

        return jdbc.query(sql, mapper); // jdbc.query returns a List in itself.
    }
}
