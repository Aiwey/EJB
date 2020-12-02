package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zwierze database table.
 * 
 */
@Entity
@NamedQuery(name="Zwierze.findAll", query="SELECT z FROM Zwierze z")
public class Zwierze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZwierze;

	private byte czyDzieci;

	private byte czyZwierzeta;

	@Temporal(TemporalType.DATE)
	private Date dataAdopcji;

	@Temporal(TemporalType.DATE)
	private Date dataPrzybycia;

	@Temporal(TemporalType.DATE)
	private Date dataUrodzenia;

	private String imie;

	@Lob
	private String opis;

	private String plec;

	private String umaszczenie;

	//bi-directional many-to-one association to Adopcja
	@OneToMany(mappedBy="zwierze")
	private List<Adopcja> adopcjas;

	//bi-directional many-to-one association to Przebytachoroba
	@OneToMany(mappedBy="zwierze")
	private List<Przebytachoroba> przebytachorobas;

	//bi-directional many-to-one association to Zabieg
	@OneToMany(mappedBy="zwierze")
	private List<Zabieg> zabiegs;

	//bi-directional many-to-one association to Zwierzetyp
	@ManyToOne
	@JoinColumn(name="idTyp")
	private Zwierzetyp zwierzetyp;

	public Zwierze() {
	}

	public int getIdZwierze() {
		return this.idZwierze;
	}

	public void setIdZwierze(int idZwierze) {
		this.idZwierze = idZwierze;
	}

	public byte getCzyDzieci() {
		return this.czyDzieci;
	}

	public void setCzyDzieci(byte czyDzieci) {
		this.czyDzieci = czyDzieci;
	}

	public byte getCzyZwierzeta() {
		return this.czyZwierzeta;
	}

	public void setCzyZwierzeta(byte czyZwierzeta) {
		this.czyZwierzeta = czyZwierzeta;
	}

	public Date getDataAdopcji() {
		return this.dataAdopcji;
	}

	public void setDataAdopcji(Date dataAdopcji) {
		this.dataAdopcji = dataAdopcji;
	}

	public Date getDataPrzybycia() {
		return this.dataPrzybycia;
	}

	public void setDataPrzybycia(Date dataPrzybycia) {
		this.dataPrzybycia = dataPrzybycia;
	}

	public Date getDataUrodzenia() {
		return this.dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getPlec() {
		return this.plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public String getUmaszczenie() {
		return this.umaszczenie;
	}

	public void setUmaszczenie(String umaszczenie) {
		this.umaszczenie = umaszczenie;
	}

	public List<Adopcja> getAdopcjas() {
		return this.adopcjas;
	}

	public void setAdopcjas(List<Adopcja> adopcjas) {
		this.adopcjas = adopcjas;
	}

	public Adopcja addAdopcja(Adopcja adopcja) {
		getAdopcjas().add(adopcja);
		adopcja.setZwierze(this);

		return adopcja;
	}

	public Adopcja removeAdopcja(Adopcja adopcja) {
		getAdopcjas().remove(adopcja);
		adopcja.setZwierze(null);

		return adopcja;
	}

	public List<Przebytachoroba> getPrzebytachorobas() {
		return this.przebytachorobas;
	}

	public void setPrzebytachorobas(List<Przebytachoroba> przebytachorobas) {
		this.przebytachorobas = przebytachorobas;
	}

	public Przebytachoroba addPrzebytachoroba(Przebytachoroba przebytachoroba) {
		getPrzebytachorobas().add(przebytachoroba);
		przebytachoroba.setZwierze(this);

		return przebytachoroba;
	}

	public Przebytachoroba removePrzebytachoroba(Przebytachoroba przebytachoroba) {
		getPrzebytachorobas().remove(przebytachoroba);
		przebytachoroba.setZwierze(null);

		return przebytachoroba;
	}

	public List<Zabieg> getZabiegs() {
		return this.zabiegs;
	}

	public void setZabiegs(List<Zabieg> zabiegs) {
		this.zabiegs = zabiegs;
	}

	public Zabieg addZabieg(Zabieg zabieg) {
		getZabiegs().add(zabieg);
		zabieg.setZwierze(this);

		return zabieg;
	}

	public Zabieg removeZabieg(Zabieg zabieg) {
		getZabiegs().remove(zabieg);
		zabieg.setZwierze(null);

		return zabieg;
	}

	public Zwierzetyp getZwierzetyp() {
		return this.zwierzetyp;
	}

	public void setZwierzetyp(Zwierzetyp zwierzetyp) {
		this.zwierzetyp = zwierzetyp;
	}

}