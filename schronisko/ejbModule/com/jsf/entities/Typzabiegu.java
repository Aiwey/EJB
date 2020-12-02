package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typzabiegu database table.
 * 
 */
@Entity
@NamedQuery(name="Typzabiegu.findAll", query="SELECT t FROM Typzabiegu t")
public class Typzabiegu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypZabiegu;

	@Lob
	private String nazwa;

	//bi-directional many-to-one association to Zabieg
	@OneToMany(mappedBy="typzabiegu")
	private List<Zabieg> zabiegs;

	public Typzabiegu() {
	}

	public int getIdTypZabiegu() {
		return this.idTypZabiegu;
	}

	public void setIdTypZabiegu(int idTypZabiegu) {
		this.idTypZabiegu = idTypZabiegu;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Zabieg> getZabiegs() {
		return this.zabiegs;
	}

	public void setZabiegs(List<Zabieg> zabiegs) {
		this.zabiegs = zabiegs;
	}

	public Zabieg addZabieg(Zabieg zabieg) {
		getZabiegs().add(zabieg);
		zabieg.setTypzabiegu(this);

		return zabieg;
	}

	public Zabieg removeZabieg(Zabieg zabieg) {
		getZabiegs().remove(zabieg);
		zabieg.setTypzabiegu(null);

		return zabieg;
	}

}