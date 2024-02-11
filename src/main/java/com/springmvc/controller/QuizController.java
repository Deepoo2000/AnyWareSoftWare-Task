package com.springmvc.controller;

import com.springmvc.entity.Quiz;
import com.springmvc.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// http://localhost:8088/
@RestController
@RequestMapping("/")
public class QuizController {

    // is responsible for get info from database and inject it into controller
    private QuizService quizService;


    // inject service into controller to use it in api
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
        System.out.println("Enter the Quiz controller");
    }

    @RequestMapping(value = "/getQuiz/{id}",method = RequestMethod.GET)
    public Quiz getQuizFromDataBase(@PathVariable int id){
        System.out.println("Id: " + id);
        Quiz quiz = quizService.getQuiz(id);
        System.out.println("Quiz in Controller: " + quiz);
        if(quiz == null){
            throw new RuntimeException("Enter A Valid Id " + id);
        }
        return quiz;
    }

    @RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
    public Quiz saveNewQuiz(@RequestBody Quiz quiz){
        quiz = new Quiz("quizMath");
        Quiz  theNewQuiz = quizService.saveQuiz(quiz);
        return theNewQuiz;
    }

    @RequestMapping(value = "/deleteQuiz/{id}", method = RequestMethod.DELETE)
    public void deleteQuiz(@PathVariable int id){
        System.out.println("id: " + id);
        quizService.deleteQuiz(id);
        System.out.println("Deleting Quiz is Done");
    }

    @RequestMapping(value = "/updateQuiz/{id}", method = RequestMethod.POST)
    public void updateStudent(@PathVariable int id){
        Quiz quiz = new Quiz("quizMath");
        quizService.updateQuiz(quiz, id);
    }

}
