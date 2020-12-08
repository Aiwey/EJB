package schronisko.web;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import schronisko.dao.TypchorobyDAO;
import schronisko.entities.Typchoroby;


@Named
@ViewScoped
public class TypchorobyEditBB  {

	private static final String PAGE_TYPCHOROBY_LIST = "typchorobyList?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private Typchoroby typchoroby = new Typchoroby();
	private Typchoroby loaded = null;
	

	@EJB
	TypchorobyDAO typchorobyDAO;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	public Typchoroby getTypchoroby() {
		return typchoroby;
	}
	
	

	public void onLoad() throws IOException {
		// 1. load person passed through session
		// HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		// loaded = (Person) session.getAttribute("person");

		// 2. load person passed through flash
		loaded = (Typchoroby) flash.get("typchoroby");

		// cleaning: attribute received => delete it from session
		if (loaded != null) {
			typchoroby = loaded;
			// session.removeAttribute("person");
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³êdne u¿ycie systemu", null));
			// if (!context.isPostback()) { //possible redirect
			// context.getExternalContext().redirect("personList.xhtml");
			// context.responseComplete();
			// }
		}

	}

	public String saveData() {
		// no Person object passed
		if (loaded == null) {
			return PAGE_STAY_AT_THE_SAME;
		}

		try {
			if (typchoroby.getNazwaChoroby() == null) {
				// new record
				typchorobyDAO.create(typchoroby);
			} else {
				// existing record
				typchorobyDAO.merge(typchoroby);
			}
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wyst¹pi³ b³¹d podczas zapisu", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		return PAGE_TYPCHOROBY_LIST;
	}
}
