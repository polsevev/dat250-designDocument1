package no.hvl.dat250.jpa.assignment2;

import no.hvl.dat250.jpa.assignment2.dto.PollDto;
import no.hvl.dat250.jpa.assignment2.dto.QuestionDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Poll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pollName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EndUser owner;

    @ManyToMany
    @JoinTable(
            name = "user_access",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "poll_id"))
    private Collection<EndUser> canAccess;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.PERSIST)
    Collection<Question> questions;

    public Poll(){
        this.questions = new ArrayList<>();
    }
    public Poll(PollDto pollDto) {
        pollName = pollDto.getPollName();
        owner = null; // TODO: add users
        this.questions = new ArrayList<>();
        for (QuestionDto questionDto : pollDto.getQuestions()) {
            Question question = new Question();
            question.setQuestion(questionDto.getQuestion());
            question.setPoll(this);
            addQuestion(question);
        }
    }



    public void addQuestion(Question q){
        this.questions.add(q);
    }
    public void setUser(EndUser owner){
        this.owner = owner;
    }
    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public Long getId() {
        return id;
    }

    public String getPollName() {

        return this.pollName;
    }
    

    public Collection<Question> getQuestions(){
        return this.questions;
    }
}
