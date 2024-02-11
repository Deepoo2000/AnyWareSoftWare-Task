package com.springmvc.service;

import com.springmvc.dao.StudentDAO;
import com.springmvc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Student getStudent(int id){
        Student student = studentDAO.getStudent(id);
        System.out.println("Student in service: " + student);
        return student;
    }

    public Student saveStudent(Student student) {
        studentDAO.saveStudent(student);
        return student;
    }


    public void deleteStudent(int id) {
         studentDAO.deleteStudent(id);
    }

    public void updateStudent(Student student, int id){
        studentDAO.updateStudent(student, id);
    }

}
