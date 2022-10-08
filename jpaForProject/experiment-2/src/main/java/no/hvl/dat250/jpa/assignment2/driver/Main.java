package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;
import no.hvl.dat250.jpa.assignment2.DAO.EndUserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "mercuryPollDb";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // TODO: Persist object world corresponding to the domain model of experiment 2.

        EntityTransaction tx = em.getTransaction();
        EndUser endUser = new EndUser();
        Poll poll = new Poll();
        Question question = new Question();
        Answer answer = new Answer();

        answer.setAnswer(true);
        answer.setUser(endUser);
        answer.setQuestion(question);




        question.setQuestion("Do you like chickens?");
        question.setPoll(poll);
        question.addAnswer(answer);



        poll.setPollName("ChickenPoll");
        poll.addQuestion(question);
        poll.setUser(endUser);

        endUser.addPollOwned(poll);
        endUser.addPollAccess(poll);
        endUser.setUserName("Cesiuss");
        endUser.setPassword("Password");



        tx.begin();
        em.persist(endUser);
        em.persist(poll);
        em.persist(answer);
        em.persist(question);
        tx.commit();

        EndUser endUser1 = new EndUser();
        endUser1.setUserName("Testlol");
        EndUserDAO endUserDAO = new EndUserDAO(em);

        endUserDAO.create(endUser1);

        List<EndUser> endusers = endUserDAO.findAll();
        System.out.println(endusers);
        em.close();
        factory.close();


    }
}
