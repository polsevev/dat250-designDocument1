package no.hvl.dat250.jpa.assignment2.dto;

import no.hvl.dat250.jpa.assignment2.Question;

public class QuestionDto {
    private Long id;

    private String question;

    public QuestionDto() {}
    public QuestionDto(Question question) {
        id = question.getId();
        this.question = question.getQuestion();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
