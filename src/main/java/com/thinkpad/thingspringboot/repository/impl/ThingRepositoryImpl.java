package com.thinkpad.thingspringboot.repository.impl;

import com.thinkpad.thingspringboot.model.Thing;
import com.thinkpad.thingspringboot.repository.ThingRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ThingRepositoryImpl implements ThingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Thing> findAll() {
        TypedQuery<Thing> query = entityManager.createQuery("select t from Thing t", Thing.class);
        return query.getResultList();
    }

    @Override
    public Thing findById(Integer id) {
        TypedQuery<Thing> query = entityManager.createQuery("select t from Thing t where t.id =:id", Thing.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Thing model) {
        if (model.getId() != null) {
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Integer id) {
        Thing thing = findById(id);
        if (thing != null) {
            entityManager.remove(thing);
        }
    }

    @Override
    public List<Thing> search(String word, String stt) {
        TypedQuery<Thing> query;
        if (stt.compareTo("ASC") == 0) {
            query = entityManager.createQuery("select t from Thing t where t.name like :word order by t.name ASC ", Thing.class);
        } else {
            query = entityManager.createQuery("select t from Thing t where t.name like :word order by t.name desc ", Thing.class);
        }
        query.setParameter("word", "%" + word + "%");
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
