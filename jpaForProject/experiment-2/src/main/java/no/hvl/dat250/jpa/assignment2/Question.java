package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String question;

    @ManyToOne
    private Poll poll;

    @OneToMany
    private Collection<Answer> answers;

    public Question(){
        answers = new ArrayList<>();
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
        // TODO: implement method!
        return question;
    }

    public Collection<Answer> getAnswers(){
        return this.answers;
    }
    public Poll getPoll(){
        return this.poll;
    }
}
