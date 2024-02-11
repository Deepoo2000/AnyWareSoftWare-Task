package com.springmvc.service;

import com.springmvc.dao.TeacherDAO;
import com.springmvc.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public Teacher getTeacher(int id){
        Teacher teacher = teacherDAO.getTeacher(id);
        System.out.println("Teacher in service: " + teacher);
        return teacher;
    }

    public Teacher saveTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
        return teacher;
    }

    public void deleteTeacher(int id) {
        teacherDAO.deleteTeacher(id);
    }

    public void updateTeacher(Teacher teacher, int id){
        teacherDAO.updateTeacher(teacher, id);
    }

}
