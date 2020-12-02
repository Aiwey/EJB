package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the przebytachoroba database table.
 * 
 */
@Entity
@NamedQuery(name="Przebytachoroba.findAll", query="SELECT p FROM Przebytachoroba p")
public class Przebytachoroba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrzebytaChoroba;

	@Temporal(TemporalType.DATE)
	private Date dataRozpoczecia;

	@Temporal(TemporalType.DATE)
	private Date dataZakonczenia;

	@Lob
	private String przebieg;

	//bi-directional many-to-one association to Typchoroby
	@ManyToOne
	private Typchoroby typchoroby;

	//bi-directional many-to-one association to Zwierze
	@ManyToOne
	private Zwierze zwierze;

	public Przebytachoroba() {
	}

	public int getIdPrzebytaChoroba() {
		return this.idPrzebytaChoroba;
	}

	public void setIdPrzebytaChoroba(int idPrzebytaChoroba) {
		this.idPrzebytaChoroba = idPrzebytaChoroba;
	}

	public Date getDataRozpoczecia() {
		return this.dataRozpoczecia;
	}

	public void setDataRozpoczecia(Date dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	public Date getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public String getPrzebieg() {
		return this.przebieg;
	}

	public void setPrzebieg(String przebieg) {
		this.przebieg = przebieg;
	}

	public Typchoroby getTypchoroby() {
		return this.typchoroby;
	}

	public void setTypchoroby(Typchoroby typchoroby) {
		this.typchoroby = typchoroby;
	}

	public Zwierze getZwierze() {
		return this.zwierze;
	}

	public void setZwierze(Zwierze zwierze) {
		this.zwierze = zwierze;
	}

}