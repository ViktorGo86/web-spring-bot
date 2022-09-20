package com.bot_telegram.model;

import javax.persistence.*;

@Entity
@Table(name = "bot_answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_answer", length = 4000, nullable = false, unique = true)
    private String name;

    @Column(name = "correct_answer", nullable = false)
    private boolean correctAnswer;

    @Column(length = 4000, nullable = true)
    private String description;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id")
    private Question question;*/



    public Answer() {
    }

    public Answer(String name, boolean correctAnswer, String description, boolean enabled, Question question) {
        this.name = name;
        this.correctAnswer = correctAnswer;
        this.description = description;
        this.enabled = enabled;
        this.question = question;
    }



    public Answer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
