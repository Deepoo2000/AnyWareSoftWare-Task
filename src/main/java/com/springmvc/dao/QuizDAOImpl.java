package com.springmvc.dao;

import com.springmvc.entity.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuizDAOImpl implements QuizDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Quiz saveQuiz(Quiz quiz) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.persist(quiz);
            session.getTransaction().commit();
            System.out.println("Done inserting into database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quiz;
    }

    @Override
    @Transactional
    public Quiz getQuiz(int id) {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();
            Quiz quiz = null;
            quiz = (Quiz) session.get(Quiz.class, id);
            System.out.println("Quiz in database: " + quiz);
            return quiz;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteQuiz(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Quiz quiz = session.get(Quiz.class, id);
            session.delete(quiz);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateQuiz(Quiz newQuiz, int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Quiz oldQuiz = session.get(Quiz.class, id);
            oldQuiz = newQuiz;
            session.update(oldQuiz);
            session.getTransaction().commit();
            System.out.println("delete form database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
