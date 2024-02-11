package com.springmvc.controller;

import com.springmvc.entity.Teacher;
import com.springmvc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// http://localhost:8088/
@RestController
@RequestMapping("/")
public class TeacherController {

    // is responsible for get info from database and inject it into controller
    private TeacherService teacherService;

    // inject service into controller to use it in api
    @Autowired
    public TeacherController(TeacherService courseService) {
        this.teacherService = teacherService;
        System.out.println("Enter the Teacher controller");
    }

    @RequestMapping(value = "/getTeacher/{id}",method = RequestMethod.GET)
    public Teacher getTeacherFromDataBase(@PathVariable int id){
        System.out.println("Id: " + id);
        Teacher teacher = teacherService.getTeacher(id);
        System.out.println("Course in Controller: " + teacher);
        if(teacher == null){
            throw new RuntimeException("Enter A Valid Id " + id);
        }
        return teacher;
    }

    @RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
    public Teacher saveNewTeacher(@RequestBody Teacher teacher){
        teacher = new Teacher("mohammed");
        Teacher  theNewTeacher = teacherService.saveTeacher(teacher);
        return theNewTeacher;
    }

    @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable int id){
        System.out.println("id: " + id);
        teacherService.deleteTeacher(id);
        System.out.println("Deleting Teacher is Done");
    }

    @RequestMapping(value = "/updateTeacher/{id}", method = RequestMethod.POST)
    public void updateTeacher(@PathVariable int id){
        Teacher teacher = new Teacher("Mohammed");
        teacherService.updateTeacher(teacher, id);
    }

}
