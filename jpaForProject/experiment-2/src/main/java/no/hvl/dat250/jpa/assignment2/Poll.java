package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pollName;

    private Integer questionCount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "user_access",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "poll_id"))
    private Collection<User> canAccess;

    @OneToMany
    Collection<Question> questions;

    public Poll(){

        this.questions = new ArrayList<>();
        questionCount = 0;
    }



    public void addQuestion(Question q){
        this.questions.add(q);
        questionCount++;
    }
    public void setUser(User owner){
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

    public int getQuestionCount() {

        return this.questionCount;
    }


    public Collection<Question> getQuestions(){
        return this.questions;
    }
}
