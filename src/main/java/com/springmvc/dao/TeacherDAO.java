package com.springmvc.dao;

import com.springmvc.entity.Teacher;

public interface TeacherDAO {
    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacher(int id);

    void deleteTeacher(int id);

    void updateTeacher(Teacher teacher, int id);
}
