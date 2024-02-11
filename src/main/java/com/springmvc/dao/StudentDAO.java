package com.springmvc.dao;

import com.springmvc.entity.Student;

public interface StudentDAO {
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);

    void updateStudent(Student student, int id);
}
