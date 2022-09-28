package com.bot_telegram.repository;

import com.bot_telegram.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query(value = "SELECT * " +
            "FROM bot_answers a " +
            "inner join bot_questions q " +
            "on q.id = a.question_id " +
            "where q.id = :id", nativeQuery = true)
    Iterable<Answer> getQuestionWithAnswers(@Param("id") Integer id);

    @Query(value = "SELECT *" +
            "FROM bot_questions q " +
            "inner join bot_answers a " +
            "on q.id = a.question_id " +
            "where a.id = :id", nativeQuery = true)
    Answer getQuestionId(@Param("id") Integer id);


}
