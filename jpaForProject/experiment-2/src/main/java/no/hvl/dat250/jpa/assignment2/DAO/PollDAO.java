package no.hvl.dat250.jpa.assignment2.DAO;

import no.hvl.dat250.jpa.assignment2.EndUser;
import no.hvl.dat250.jpa.assignment2.Poll;

import javax.persistence.EntityManager;

public class PollDAO extends DAO<Poll>{

    public PollDAO(EntityManager manager){
        super.entityManager = manager;
        setClazz(Poll.class );
    }
}
