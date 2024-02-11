package com.springmvc.dao;

import com.springmvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.persist(student);
            session.getTransaction().commit();
            System.out.println("Done inserting into database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();
            Student student = null;
            student = (Student) session.get(Student.class, id);
            System.out.println("Student in database: " + student);
            return student;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateStudent(Student newStudent, int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Student oldStudent = session.get(Student.class, id);
            oldStudent = newStudent;
            session.update(oldStudent);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
