package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private boolean answer;

    @OneToOne
    private User user;

    @ManyToOne
    private Question question;

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public User getUser() {
        return user;
    }
    public boolean getAnswer(){
        return this.answer;
    }
}
