package no.hvl.dat250.jpa.assignment2;

import no.hvl.dat250.jpa.assignment2.dto.QuestionDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String question;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @OneToMany(mappedBy = "question")
    private Collection<Answer> answers;

    public Question(){
        answers = new ArrayList<>();
    }
    public Question(QuestionDto dto, Poll poll) {
        this.poll = poll;
        question = dto.getQuestion();
    }



    public void setPoll(Poll poll){
        this.poll = poll;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }
    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Collection<Answer> getAnswers(){
        return this.answers;
    }
    public Poll getPoll(){
        return this.poll;
    }
}
