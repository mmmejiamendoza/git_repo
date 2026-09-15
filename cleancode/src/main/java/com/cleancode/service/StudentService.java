package com.cleancode.service;

import java.util.List;

import com.cleancode.domain.Student;

public interface StudentService {
    void addStudent(Student student);
    Student findStudent(int id);
    List<Student> findAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}