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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EndUser owner;

    @ManyToMany
    @JoinTable(
            name = "user_access",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "poll_id"))
    private Collection<EndUser> canAccess;

    @OneToMany(mappedBy = "poll")
    Collection<Question> questions;

    public Poll(){

        this.questions = new ArrayList<>();
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
