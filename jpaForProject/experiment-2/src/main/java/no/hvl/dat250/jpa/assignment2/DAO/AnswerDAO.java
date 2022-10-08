package no.hvl.dat250.jpa.assignment2.DAO;

import no.hvl.dat250.jpa.assignment2.Answer;

import javax.persistence.EntityManager;

public class AnswerDAO extends DAO<Answer>{

    public AnswerDAO(EntityManager manager){
        super.entityManager = manager;
        setClazz(Answer.class );
    }
}
