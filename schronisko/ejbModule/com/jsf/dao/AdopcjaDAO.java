package com.jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jsf.entities.Adopcja;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class AdopcjaDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Adopcja adopcja) {
		em.persist(adopcja); //utrwal
	}

	public Adopcja merge(Adopcja adopcja) {
		return em.merge(adopcja); //
	}

	public void remove(Adopcja adopcja) {
		em.remove(em.merge(adopcja));
	}

	public Adopcja find(Object id) {
		return em.find(Adopcja.class, id);
	}

	public List<Adopcja> getFullList() {
		List<Adopcja> list = null;

		Query query = em.createQuery("select a from Adopcja a");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


}
