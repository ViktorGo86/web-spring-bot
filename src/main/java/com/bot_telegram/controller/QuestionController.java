package com.bot_telegram.controller;

import com.bot_telegram.model.Answer;
import com.bot_telegram.model.Question;
import com.bot_telegram.repository.AnswerRepository;
import com.bot_telegram.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository repo;

    @Autowired
    private AnswerRepository answerRepo;

    @GetMapping("/questions")
    public String listQuestions(Model model) {
        List<Question> listQuestions = repo.findAll();
        model.addAttribute("listQuestions", listQuestions);
        return "questions";
    }

    @GetMapping("/questions/new")
    public String showQuestionNewFormModel(Model model) {
        model.addAttribute("question", new Question());

        return "question_form";
    }

    @PostMapping("/questions/save")
    public String saveQuestion(Question question) {
        repo.save(question);

        return "redirect:/questions";
		
    }

    @GetMapping("/questions/edit/{id}")
    public String showEditQuestionForm(@PathVariable("id") Integer id, Model model) {
        Question question = repo.findById(id).get();
        model.addAttribute("question", question);

        return "question_form";
    }

    @GetMapping("/questions/delete/{id}")
    public String deleteQuestion(@PathVariable("id") Integer id, Model model) {
        repo.deleteById(id);
        //answerRepo.deleteById(id);

        return "redirect:/questions";
    }

    /*@GetMapping("/questions/question_answers/{id}")
    public String listByIdQuestionAnswers(@PathVariable("id") Integer id, @RequestBody Answer answer) {
        answer.setQuestion(id);
        answerRepo.findAll(answer);

    }*/

    @GetMapping("/questions/question_answers/{id}")
    public String listByIdQuestionAnswers(@PathVariable("id") Integer id,Model model) {
        Question question = repo.findById(id).get();
        model.addAttribute("question", question);

        /*List<Answer> listAnswers = answerRepo.findAll();
        model.addAttribute("listAnswers", listAnswers);
        return "question_answers";*/
        Iterable<Answer> listAnswersQuestion = answerRepo.getQuestionWithAnswers(id);
        model.addAttribute("listAnswersQuestion", listAnswersQuestion);

        return "question_answers";
    }

    @GetMapping("/questions/question_answers/delete/{id}")
    public String deleteQuestionAnswers(@PathVariable("id") Integer id, Model model) {
        //Iterable<Answer> questionId = answerRepo.getQuestionId(id);
        Answer questionAnsId = answerRepo.getQuestionId(id);
                //System.out.println("questionId = "+questionId.getId());
        //System.out.println("*******************************************************************");
        //System.out.println("questionId2222222 = "+answerRepo.getQuestionId(id));
        answerRepo.deleteById(id);

        return "redirect:/questions/question_answers/"+questionAnsId.getId();
    }

    @GetMapping("/questions/question_answers/new/{id}")
    public String showNewQuestionAnswersForm(@PathVariable("id") Integer id, Model model) {
        Question question = repo.findById(id).get();
        //model.addAttribute("question", question);
        //List<Question> listQuestions = repo.findAll();


        System.out.println("*******************************************************************");
        System.out.println("question = "+question.getId());

        model.addAttribute("answer", new Answer());
        model.addAttribute("listQuestions", question);//listQuestions);

        return "question_answers_form";
    }

}
