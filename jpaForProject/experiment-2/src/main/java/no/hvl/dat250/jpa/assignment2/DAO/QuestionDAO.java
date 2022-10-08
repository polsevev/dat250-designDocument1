package no.hvl.dat250.jpa.assignment2.DAO;

import no.hvl.dat250.jpa.assignment2.Question;

import javax.persistence.EntityManager;

public class QuestionDAO extends DAO<Question>{
    public QuestionDAO(EntityManager manager){
        super.entityManager = manager;
        setClazz(Question.class );
    }
}
