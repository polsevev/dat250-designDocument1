package no.hvl.dat250.jpa.assignment2.DAO;

import no.hvl.dat250.jpa.assignment2.Answer;
import no.hvl.dat250.jpa.assignment2.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class QuestionDAO extends DAO<Question>{
    public QuestionDAO(EntityManager manager){
        super.entityManager = manager;
        setClazz(Question.class );
    }

    public void delete(Question entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        for (Answer a : entity.getAnswers()) {
            entityManager.remove(a);
        }
        entityManager.remove(entity);
        tx.commit();
    }
}
