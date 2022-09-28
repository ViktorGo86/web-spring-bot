package com.bot_telegram.controller;

import com.bot_telegram.repository.AnswerRepository;
import com.bot_telegram.model.Answer;
import com.bot_telegram.model.Question;
import com.bot_telegram.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @PostMapping("/questions/question_answers/save")
    public String saveAnswer(Answer answer) {
        answerRepo.save(answer);

        return "redirect:/questions/question_answers/"+answer.getQuestion().getId();
    }

    @GetMapping("/questions/question_answers/edit/{id}")
    public String showEditAnswerForm(@PathVariable("id") Integer id, Model model) {
        Answer answer = answerRepo.findById(id).get();
        model.addAttribute("answer", answer);

        List<Question> listQuestions = questionRepo.findAll();
        model.addAttribute("listQuestions", listQuestions);

        return "question_answers_form";
    }

}
