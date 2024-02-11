package com.springmvc.service;

import com.springmvc.dao.QuizDAO;
import com.springmvc.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuizService {

    @Autowired
    private QuizDAO quizDAO;

    public Quiz getQuiz(int id){
        Quiz quiz = quizDAO.getQuiz(id);
        System.out.println("quiz in service: " + quiz);
        return quiz;
    }

    public Quiz saveQuiz(Quiz quiz) {
        quizDAO.saveQuiz(quiz);
        return quiz;
    }

    public void deleteQuiz(int id) {
        quizDAO.deleteQuiz(id);
    }

    public void updateQuiz(Quiz quiz, int id){
        quizDAO.updateQuiz(quiz, id);
    }

}
