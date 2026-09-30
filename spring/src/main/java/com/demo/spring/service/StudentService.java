package com.demo.spring.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.demo.spring.dao.StudentDAO;
import com.demo.spring.domain.Student;
import com.demo.spring.exceptions.StudentNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service 
public class StudentService {

    private final StudentDAO studentDAO;
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    public StudentService(@Qualifier("entityManagerStudentDAO")StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional 
    public Student insertStudent(Student student) {
        return studentDAO.insert(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(int id) {

        Student student = studentDAO.findById(id);

        if(student == null) {
            throw new StudentNotFoundException("student not found w/id: " + id);
        }
        return student;
    }

    @Transactional 
    public void deleteStudent(int id) {
        Student student = getStudentById(id);
        studentDAO.delete(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getStudentsByLastName(String lastName) {
        return studentDAO.findByLastName(lastName);
    }

    /*
    we dont need a call to DAO here
    since this is in a transaction and existingSTudent is a managed
    entitiy and changes to it will be traced b4 the transaction closes,
    dirty checking will occurs this will detect the change to the managed entity
    and the changes will be auto commited
     */
    
    @Transactional 
    public Student updsateStudent(int id, Student student) {
      Student existingStudent = getStudentById(id);

      existingStudent.setEmail(student.getEmail());
      existingStudent.setFirstName(student.getFirstName());
      existingStudent.setLastName(student.getLastName());

      return existingStudent;
    }
}
