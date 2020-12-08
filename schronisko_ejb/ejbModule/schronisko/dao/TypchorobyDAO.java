package schronisko.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import schronisko.entities.Typchoroby;

@Stateless
public class TypchorobyDAO {
	
	private final static String UNIT_NAME = "jsfcourse-simplePU";
	@PersistenceContext(unitName = UNIT_NAME)
	EntityManager em;
public void create(Typchoroby typchoroby) {
	em.persist(typchoroby); //insert
}

public Typchoroby merge(Typchoroby typchoroby) {
	return em.merge(typchoroby); //update
}

public void remove(Typchoroby typchoroby) {
	em.remove(em.merge(typchoroby)); //delete
}

public Typchoroby find(Object id) {
	return em.find(Typchoroby.class, id); //get+
}


public List<Typchoroby> getFullList() {
	List<Typchoroby> list = null;

	Query query = em.createQuery("select t from Typchoroby t");

	try {
		list = query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}

public List<Typchoroby> getList(Map<String, Object> searchParams) {
	List<Typchoroby> list = null;

	// 1. Build query string with parameters
	String select = "select t ";
	String from = "from Typchoroby t ";
	String where = "";
	String orderby = "order by t.nazwaChoroby asc";

	// search for nazwaChoroby
	String nazwaChoroby = (String) searchParams.get("nazwaChoroby");
	if (nazwaChoroby != null) {
		if (where.isEmpty()) {
			where = "where ";
		} else {
			where += "and ";
		}
		where += "t.nazwaChoroby like :nazwaChoroby ";
	}
	
	// ... other parameters ... 

	// 2. Create query object
	Query query = em.createQuery(select + from + where + orderby);

	// 3. Set configured parameters
	if (nazwaChoroby != null) {
		query.setParameter("nazwaChoroby", nazwaChoroby+"%");
	}

	// ... other parameters ... 

	// 4. Execute query and retrieve list of Typchoroby objects
	try {
		list = query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}

}
