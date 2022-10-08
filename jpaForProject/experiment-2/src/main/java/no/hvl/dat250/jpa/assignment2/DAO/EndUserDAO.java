package no.hvl.dat250.jpa.assignment2.DAO;


import no.hvl.dat250.jpa.assignment2.EndUser;

import javax.persistence.EntityManager;


public class EndUserDAO extends DAO<EndUser>{

    public EndUserDAO(EntityManager manager){
        super.entityManager = manager;
        setClazz(EndUser.class );
    }
}

