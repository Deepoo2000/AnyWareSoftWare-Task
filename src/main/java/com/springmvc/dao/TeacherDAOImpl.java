package com.springmvc.dao;

import com.springmvc.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.persist(teacher);
            session.getTransaction().commit();
            System.out.println("Done inserting into database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    @Transactional
    public Teacher getTeacher(int id) {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();
            Teacher teacher = null;
            teacher = (Teacher) session.get(Teacher.class, id);
            System.out.println("Teacher in database: " + teacher);
            return teacher;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteTeacher(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Teacher teacher = session.get(Teacher.class, id);
            session.delete(teacher);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateTeacher(Teacher newTeacher, int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Teacher oldTeacher = session.get(Teacher.class, id);
            oldTeacher = newTeacher;
            session.update(oldTeacher);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
