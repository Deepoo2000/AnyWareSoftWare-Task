package com.springmvc.dao;

import com.springmvc.entity.Quiz;

public interface QuizDAO {
    Quiz saveQuiz(Quiz quiz);

    Quiz getQuiz(int id);

    void deleteQuiz(int id);

    void updateQuiz(Quiz quiz, int id);
}
