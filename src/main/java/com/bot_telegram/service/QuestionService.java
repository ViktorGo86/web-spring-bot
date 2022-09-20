package com.bot_telegram.service;

import com.bot_telegram.model.Question;
import com.bot_telegram.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repo;

    public Question save(Question question) {
        return repo.save(question);
    }


}
