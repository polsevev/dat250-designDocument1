package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class EndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Collection<Poll> pollsOwned;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "canAccess")
    private Collection<Poll> pollsAccessable;

    @OneToMany
    private Collection<Answer> answers;

    public EndUser(){
        this.pollsOwned = new ArrayList<>();
        this.pollsAccessable = new ArrayList<>();
        this.answers = new ArrayList<>();
    }
    public void addPollOwned(Poll poll){
        this.pollsOwned.add(poll);
    }

    public void addPollAccess(Poll ac){
        this.pollsAccessable.add(ac);
    }

    public Collection<Poll> getPollsOwned(){
        return this.pollsOwned;
    }

    public Collection<Poll> getPollsAccessable() {
        return pollsAccessable;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }
}
