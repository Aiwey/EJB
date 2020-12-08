package schronisko.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import schronisko.entities.Adopcja;

@Stateless
public class AdopcjaDAO {
	
	private final static String UNIT_NAME = "jsfcourse-simplePU";
	@PersistenceContext
	EntityManager em;
public void create(Adopcja adopcja) {
	em.persist(adopcja); //insert
}

public Adopcja merge(Adopcja adopcja) {
	return em.merge(adopcja); //update
}

public void remove(Adopcja adopcja) {
	em.remove(em.merge(adopcja)); //delete
}

public Adopcja find(Object id) {
	return em.find(Adopcja.class, id); //get+
}
}
