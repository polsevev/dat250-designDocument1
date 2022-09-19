package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class Answer {
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
