package schronisko.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typchoroby database table.
 * 
 */
@Entity
@NamedQuery(name="Typchoroby.findAll", query="SELECT t FROM Typchoroby t")
public class Typchoroby implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idChoroba;

	private byte czyUleczalna;

	@Lob
	private String nazwaChoroby;

	//bi-directional many-to-one association to Przebytachoroba
	@OneToMany(mappedBy="typchoroby")
	private List<Przebytachoroba> przebytachorobas;

	public Typchoroby() {
	}

	public Integer getIdChoroba() {
		return this.idChoroba;
	}

	public void setIdChoroba(int idChoroba) {
		this.idChoroba = idChoroba;
	}

	public byte getCzyUleczalna() {
		return this.czyUleczalna;
	}

	public void setCzyUleczalna(byte czyUleczalna) {
		this.czyUleczalna = czyUleczalna;
	}

	public String getNazwaChoroby() {
		return this.nazwaChoroby;
	}

	public void setNazwaChoroby(String nazwaChoroby) {
		this.nazwaChoroby = nazwaChoroby;
	}

	public List<Przebytachoroba> getPrzebytachorobas() {
		return this.przebytachorobas;
	}

	public void setPrzebytachorobas(List<Przebytachoroba> przebytachorobas) {
		this.przebytachorobas = przebytachorobas;
	}

	public Przebytachoroba addPrzebytachoroba(Przebytachoroba przebytachoroba) {
		getPrzebytachorobas().add(przebytachoroba);
		przebytachoroba.setTypchoroby(this);

		return przebytachoroba;
	}

	public Przebytachoroba removePrzebytachoroba(Przebytachoroba przebytachoroba) {
		getPrzebytachorobas().remove(przebytachoroba);
		przebytachoroba.setTypchoroby(null);

		return przebytachoroba;
	}

}