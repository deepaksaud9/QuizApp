package com.depp.quizapp.dao;

import com.depp.quizapp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    Optional<List<Question>> getQuestionsByCategory(String category);


    //JPQL query
    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RAND()  LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
