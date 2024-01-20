package com.depp.quizapp.controller;

import com.depp.quizapp.dao.QuestionDao;
import com.depp.quizapp.entities.Question;
import com.depp.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {


    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok().body(questions);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){

        List<Question> questionsByCategory = questionService.getAllQuestionsByCategory(category);

        return ResponseEntity.ok().body(questionsByCategory);
    }

    @PostMapping("/add-question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){

        Question addQuestion = questionService.createQuestion(question);

        return new ResponseEntity(addQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/update-question/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question question){

        Question questionUpdated = questionService.updateQuestion(id,question);

        return new ResponseEntity(questionUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/delete-question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){

        String deleted = questionService.deleteQuestion(id);
        return ResponseEntity.ok().body(deleted);
    }

}
