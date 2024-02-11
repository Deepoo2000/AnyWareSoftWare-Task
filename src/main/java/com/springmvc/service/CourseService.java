package com.springmvc.service;

import com.springmvc.dao.CourseDAO;
import com.springmvc.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

    @Autowired
    private CourseDAO courseDAO;

    public Course getCourse(int id){
        Course course = courseDAO.getCourse(id);
        System.out.println("Course in service: " + course);
        return course;
    }

    public Course saveCourse(Course course) {
        courseDAO.saveCourse(course);
        return course;
    }


    public void deleteCourse(int id) {
        courseDAO.deleteCourse(id);
    }

    public void updateCourse(Course course, int id){
        courseDAO.updateCourse(course, id);
    }

}
