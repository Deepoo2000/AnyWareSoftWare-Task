package com.springmvc.controller;

import com.springmvc.entity.Student;
import com.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// http://localhost:8088/
@RestController
@RequestMapping("/")
public class StudentController {

    // is responsible for get info from database and inject it into controller
    private StudentService studentService;

    // inject service into controller to use it in api
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        System.out.println("Enter the student controller");
    }

    @RequestMapping(value = "/getStudent/{id}",method = RequestMethod.GET)
    public Student getStudentFromDataBase(@PathVariable int id){
        System.out.println("Id: " + id);
        Student student = studentService.getStudent(id);
        System.out.println("Student in Controller: " + student);
        if(student == null){
            throw new RuntimeException("Enter A Valid Id " + id);
        }
        return student;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Student saveNewStudent(@RequestBody Student student){
        student = new Student("Deepoo");
        Student theNewStudent = studentService.saveStudent(student);
        return theNewStudent;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id){
        System.out.println("id: " + id);
        studentService.deleteStudent(id);
        System.out.println("Deleting Student is Done");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void updateStudent(@PathVariable int id){
        Student student = new Student("shimaa");
        studentService.updateStudent(student, id);
    }




}
