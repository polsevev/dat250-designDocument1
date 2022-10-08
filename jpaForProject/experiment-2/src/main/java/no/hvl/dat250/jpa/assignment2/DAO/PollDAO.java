package no.hvl.dat250.jpa.assignment2.DAO;

import no.hvl.dat250.jpa.assignment2.Answer;
import no.hvl.dat250.jpa.assignment2.Poll;
import no.hvl.dat250.jpa.assignment2.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PollDAO extends DAO<Poll>{

    public PollDAO(EntityManager manager){
        super.entityManager = manager;
        setClazz(Poll.class );
    }

    @Override
    public void delete( Poll entity ){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        for (Question q : entity.getQuestions()){
            for (Answer a: q.getAnswers()){
                entityManager.remove(a);
            }
            entityManager.remove(q);
        }
        entityManager.remove( entity );
        tx.commit();
    }
}
