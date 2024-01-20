package com.depp.quizapp.service;

import com.depp.quizapp.dao.QuestionDao;
import com.depp.quizapp.entities.Question;
import com.depp.quizapp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
    public List<Question> getAllQuestions() {

        List<Question> questionsList = questionDao.findAll();
        if (questionsList==null){
            throw new NotFoundException("data not found or data not available in database");
        }
        return questionsList;
    }

    public List<Question> getAllQuestionsByCategory(String category) {

        List<Question> questionByCategoryList = questionDao.getQuestionsByCategory(category).get();
        if (questionByCategoryList==null){
            throw new NotFoundException("No any list or data available");
        }

        return questionByCategoryList;

    }

    public Question createQuestion(Question question) {

        Question question1 = new Question();

        question1.setQuestionTitle(question.getQuestionTitle());
        question1.setOption1(question.getOption1());
        question1.setOption2(question.getOption2());
        question1.setOption3(question.getOption3());
        question1.setOption4(question.getOption4());
        question1.setCorrectAnswer(question.getCorrectAnswer());
        question1.setDifficultyLevel(question.getDifficultyLevel());
        question1.setCategory(question.getCategory());


       Question savedQuestion = questionDao.save(question1);

        return savedQuestion;
    }

    public Question updateQuestion( Integer id,Question question) {

        Question questionUpdate = questionDao.findById(id).get();
        if (questionUpdate==null){
            throw new NotFoundException("id not found");
        }

        questionUpdate.setQuestionTitle(question.getQuestionTitle());
        questionUpdate.setOption1(question.getOption1());
        questionUpdate.setOption2(question.getOption2());
        questionUpdate.setOption3(question.getOption3());
        questionUpdate.setOption4(question.getOption4());
        questionUpdate.setCorrectAnswer(question.getCorrectAnswer());
        questionUpdate.setDifficultyLevel(question.getDifficultyLevel());
        questionUpdate.setCategory(question.getCategory());

        Question updatedQuestion = questionDao.save(questionUpdate);

        return updatedQuestion;

    }

    public String deleteQuestion(int id){
       Optional<Question> question = questionDao.findById(id);

       if (!question.isPresent()){
           throw new NotFoundException("Id not present");
       }
        questionDao.delete(question.get());

       return "question deleted";
    }
}

