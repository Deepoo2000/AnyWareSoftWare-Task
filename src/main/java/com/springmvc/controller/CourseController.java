package com.springmvc.controller;

import com.springmvc.entity.Course;
import com.springmvc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// http://localhost:8088/
@RestController
@RequestMapping("/")
public class CourseController {

    // is responsible for get info from database and inject it into controller
    private CourseService courseService;

    // inject service into controller to use it in api
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
        System.out.println("Enter the Course controller");
    }

    @RequestMapping(value = "/getCourse/{id}",method = RequestMethod.GET)
    public Course getCourseFromDataBase(@PathVariable int id){
        System.out.println("Id: " + id);
        Course course = courseService.getCourse(id);
        System.out.println("Course in Controller: " + course);
        if(course == null){
            throw new RuntimeException("Enter A Valid Id " + id);
        }
        return course;
    }

    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public Course saveNewCourse(@RequestBody Course course){
        course = new Course("Math");
        Course theNewStudent = courseService.saveCourse(course);
        return theNewStudent;
    }

    @RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable int id){
        System.out.println("id: " + id);
        courseService.deleteCourse(id);
        System.out.println("Deleting Course is Done");
    }

    @RequestMapping(value = "/updateCourse/{id}", method = RequestMethod.POST)
    public void updateCourse(@PathVariable int id){
        Course course = new Course("Math");
        courseService.updateCourse(course, id);
    }




}
