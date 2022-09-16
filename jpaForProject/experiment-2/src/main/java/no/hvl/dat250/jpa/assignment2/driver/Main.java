package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "mercuryPollDb";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // TODO: Persist object world corresponding to the domain model of experiment 2.

        EntityTransaction tx = em.getTransaction();
        User user = new User();
        Poll poll = new Poll();
        Question question = new Question();
        Answer answer = new Answer();

        answer.setAnswer(true);
        answer.setUser(user);
        answer.setQuestion(question);




        question.setQuestion("Do you like chickens?");
        question.setPoll(poll);
        question.addAnswer(answer);



        poll.setPollName("ChickenPoll");
        poll.addQuestion(question);
        poll.setUser(user);

        user.addPollOwned(poll);
        user.addPollAccess(poll);
        user.setUserName("Cesiuss");
        user.setPassword("Password");



        tx.begin();
        em.persist(user);
        em.persist(poll);
        em.persist(answer);
        em.persist(question);
        tx.commit();


        em.close();
        factory.close();


    }
}
