package no.hvl.dat250.jpa.assignment2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class DAO< T extends Serializable> {

    private Class< T > clazz;


    EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){

        return entityManager.find( clazz, id );

    }
    public List<T> findAll(){
        return entityManager.createQuery( "select t from " + clazz.getName() + " t")
                .getResultList();
    }

    public void create( T entity ){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist( entity );
        tx.commit();

    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void delete( T entity ){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove( entity );
        tx.commit();
    }
    public void deleteById( long entityId ){
        EntityTransaction tx = entityManager.getTransaction();
        T entity = findOne( entityId );

        delete( entity );


    }

}