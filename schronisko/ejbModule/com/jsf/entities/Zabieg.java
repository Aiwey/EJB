package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zabieg database table.
 * 
 */
@Entity
@NamedQuery(name="Zabieg.findAll", query="SELECT z FROM Zabieg z")
public class Zabieg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZabieg;

	@Temporal(TemporalType.DATE)
	private Date dataZabiegu;

	private double koszt;

	//bi-directional many-to-one association to Typzabiegu
	@ManyToOne
	@JoinColumn(name="idTypZabiegu")
	private Typzabiegu typzabiegu;

	//bi-directional many-to-one association to Zwierze
	@ManyToOne
	@JoinColumn(name="idZwierze")
	private Zwierze zwierze;

	public Zabieg() {
	}

	public int getIdZabieg() {
		return this.idZabieg;
	}

	public void setIdZabieg(int idZabieg) {
		this.idZabieg = idZabieg;
	}

	public Date getDataZabiegu() {
		return this.dataZabiegu;
	}

	public void setDataZabiegu(Date dataZabiegu) {
		this.dataZabiegu = dataZabiegu;
	}

	public double getKoszt() {
		return this.koszt;
	}

	public void setKoszt(double koszt) {
		this.koszt = koszt;
	}

	public Typzabiegu getTypzabiegu() {
		return this.typzabiegu;
	}

	public void setTypzabiegu(Typzabiegu typzabiegu) {
		this.typzabiegu = typzabiegu;
	}

	public Zwierze getZwierze() {
		return this.zwierze;
	}

	public void setZwierze(Zwierze zwierze) {
		this.zwierze = zwierze;
	}

}