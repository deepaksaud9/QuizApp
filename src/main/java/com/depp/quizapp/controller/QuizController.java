package com.depp.quizapp.controller;

import com.depp.quizapp.entities.Quiz;
import com.depp.quizapp.pojo.QuestionPojo;
import com.depp.quizapp.pojo.Response;
import com.depp.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        System.out.println("hello people ");

           Quiz quiz = quizService.createQuiz(category,numQ,title);

        return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
    }

    @GetMapping("/get-quiz-details/{id}")
    public ResponseEntity<Quiz> getQuizDetailsById(@PathVariable int id){

        Quiz quiz = quizService.getQuizById(id);

        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }

    @GetMapping("/get-quiz/{id}")
    public ResponseEntity<List<QuestionPojo>> getQuizById(@PathVariable int id){

        List<QuestionPojo> quiz = quizService.setQuizQuestions(id);

        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }

    @PostMapping("/submit-answer/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){

        Integer score = quizService.calculateResult(id,responses);

        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
