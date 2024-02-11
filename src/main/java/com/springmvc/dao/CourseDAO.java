package com.springmvc.dao;

import com.springmvc.entity.Course;

public interface CourseDAO {
    Course saveCourse(Course course);

    Course getCourse(int id);

    void deleteCourse(int id);

    void updateCourse(Course course, int id);
}
