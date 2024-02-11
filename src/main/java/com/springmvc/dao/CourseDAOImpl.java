package com.springmvc.dao;

import com.springmvc.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.persist(course);
            session.getTransaction().commit();
            System.out.println("Done inserting into database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    @Transactional
    public Course getCourse(int id) {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();
            Course course = null;
            course = (Course) session.get(Course.class, id);
            System.out.println("Course in database: " + course);
            return course;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Course course = session.get(Course.class, id);
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateCourse(Course newCourse, int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Course oldCourse = session.get(Course.class, id);
            oldCourse = newCourse;
            session.update(oldCourse);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
