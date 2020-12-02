package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the adopcja database table.
 * 
 */
@Entity
@NamedQuery(name="Adopcja.findAll", query="SELECT a FROM Adopcja a")
public class Adopcja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idAdopcja;

	@Temporal(TemporalType.DATE)
	private Date dataAdopcji;

	@Temporal(TemporalType.DATE)
	private Date dataOddania;

	//bi-directional many-to-one association to Rodzina
	@ManyToOne
	@JoinColumn(name="idRodzina")
	private Rodzina rodzina;

	//bi-directional many-to-one association to Zwierze
	@ManyToOne
	@JoinColumn(name="idZwierze")
	private Zwierze zwierze;

	public Adopcja() {
	}

	public String getIdAdopcja() {
		return this.idAdopcja;
	}

	public void setIdAdopcja(String idAdopcja) {
		this.idAdopcja = idAdopcja;
	}

	public Date getDataAdopcji() {
		return this.dataAdopcji;
	}

	public void setDataAdopcji(Date dataAdopcji) {
		this.dataAdopcji = dataAdopcji;
	}

	public Date getDataOddania() {
		return this.dataOddania;
	}

	public void setDataOddania(Date dataOddania) {
		this.dataOddania = dataOddania;
	}

	public Rodzina getRodzina() {
		return this.rodzina;
	}

	public void setRodzina(Rodzina rodzina) {
		this.rodzina = rodzina;
	}

	public Zwierze getZwierze() {
		return this.zwierze;
	}

	public void setZwierze(Zwierze zwierze) {
		this.zwierze = zwierze;
	}

}