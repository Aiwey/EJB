package schronisko.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import schronisko.dao.TypchorobyDAO;
import schronisko.entities.Typchoroby;


@Named
@RequestScoped
public class TypchorobyListBB {
	private static final String PAGE_PERSON_EDIT = "typchorobyEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nazwaChoroby;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	TypchorobyDAO typchorobyDAO;
		
	public String getNazwaChoroby() {
		return nazwaChoroby;
	}

	public void setNazwaChoroby(String nazwaChoroby) {
		this.nazwaChoroby = nazwaChoroby;
	}

	public List<Typchoroby> getFullList(){
		return typchorobyDAO.getFullList();
	}

	public List<Typchoroby> getList(){
		List<Typchoroby> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwaChoroby != null && nazwaChoroby.length() > 0){
			searchParams.put("nazwaChoroby", nazwaChoroby);
		}
		
		//2. Get list
		list = typchorobyDAO.getList(searchParams);
		
		return list;
	}

	public String newTypchoroby(){
		Typchoroby typChoroby = new Typchoroby();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("typChoroby", typChoroby);
		
		//2. Pass object through flash	
		flash.put("typChoroby", typChoroby);
		
		return PAGE_PERSON_EDIT;
	}

	public String editTypchoroby(Typchoroby typChoroby){
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("typChoroby", typChoroby);
		
		//2. Pass object through flash 
		flash.put("typChoroby", typChoroby);
		
		return PAGE_PERSON_EDIT;
	}

	public String deleteTypchoroby(Typchoroby typChoroby){
		typchorobyDAO.remove(typChoroby);
		return PAGE_STAY_AT_THE_SAME;
	}
}
