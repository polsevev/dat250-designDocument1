package no.hvl.dat250.jpa.assignment2;

import no.hvl.dat250.jpa.assignment2.dto.AnswerDto;
import no.hvl.dat250.jpa.assignment2.dto.QuestionDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private boolean answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="endUser_id")
    private EndUser endUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;

    public Answer(){

    }
    public Answer(AnswerDto dto, Question q){
        this.answer = dto.getAnswer();
        this.endUser = null;
        this.question = q;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUser(EndUser endUser) {
        this.endUser = endUser;
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public EndUser getUser() {
        return endUser;
    }
    public boolean getAnswer(){
        return this.answer;
    }
}
