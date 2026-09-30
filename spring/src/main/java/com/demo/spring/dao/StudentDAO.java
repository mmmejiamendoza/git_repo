package com.demo.spring.dao;

import java.util.List;
import com.demo.spring.domain.Student;

public interface StudentDAO {

    Student insert(Student student);
    List<Student> findAll();
    Student findById(int id);
    void delete(Student student);
    List<Student> findByLastName(String lastName);
}
