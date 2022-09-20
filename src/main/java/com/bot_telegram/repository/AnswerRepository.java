package com.bot_telegram.repository;

import com.bot_telegram.model.Answer;
import com.bot_telegram.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    //Page<Answer> findByPostId(Long postId, Pageable pageable);
   /* Page<Answer> findByQuestionId(Integer questionId, Pageable pageable);
    Optional<Answer> findByIdAndQuestionId(Integer id, Integer questionId);*/

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
    //Iterable<Answer> getQuestionId(@Param("id") Integer id);
    Answer getQuestionId(@Param("id") Integer id);


}
