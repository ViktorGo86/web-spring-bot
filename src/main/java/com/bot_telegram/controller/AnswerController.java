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

   /* @GetMapping("/answers/new")
    public String showNewProductForm(Model model) {
        List<Question> listQuestions = questionRepo.findAll();

        model.addAttribute("answer", new Answer());
        model.addAttribute("listQuestions", listQuestions);

        return "answer_form";
    }*/

    /*@PostMapping("/answers/save")
    public String saveAnswer(Answer answer) {
        answerRepo.save(answer);

        //return "redirect:/answers";
        return "redirect:/questions/question_answers/";
        //return "redirect:/questions/question_answers/"+questionAnsId.getId();
    }*/
    @PostMapping("/questions/question_answers/save")
    public String saveAnswer(Answer answer) {
        //Answer questionAnsId = answerRepo.getQuestionId(id);
        //System.out.println("answer.getId() = "+answer.getId());
        //System.out.println("answer.getId() = "+answer.getQuestion().getId());

        answerRepo.save(answer);

        System.out.println("*******************************************************************");
        //System.out.println("answer.getId() = "+answer.getId());
        System.out.println("answer.getId() = "+answer.getQuestion().getId());
        //System.out.println("answerRepo.getQuestionId(answer.getId()) = "+answerRepo.getQuestionId(answer.getId()));


        //return "redirect:/answers";
        //return "redirect:/questions";
        return "redirect:/questions/question_answers/"+answer.getQuestion().getId();
    }

    /*@GetMapping("/answers")
    public String listAnswers(Model model) {
        List<Answer> listAnswers = answerRepo.findAll();
        model.addAttribute("listAnswers", listAnswers);
        return "answers";
    }*/

   // @GetMapping("/answers/edit/{id}")
    @GetMapping("/questions/question_answers/edit/{id}")
    public String showEditAnswerForm(@PathVariable("id") Integer id, Model model) {
        Answer answer = answerRepo.findById(id).get();
        model.addAttribute("answer", answer);

        List<Question> listQuestions = questionRepo.findAll();
        model.addAttribute("listQuestions", listQuestions);

        //return "answer_form";
        return "question_answers_form";
    }

   /* @GetMapping("/answers/delete/{id}")
    public String deleteAnswer(@PathVariable("id") Integer id, Model model) {
        answerRepo.deleteById(id);

        return "redirect:/answers";
    }*/






}
