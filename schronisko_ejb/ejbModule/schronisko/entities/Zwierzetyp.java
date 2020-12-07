package schronisko.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zwierzetyp database table.
 * 
 */
@Entity
@NamedQuery(name="Zwierzetyp.findAll", query="SELECT z FROM Zwierzetyp z")
public class Zwierzetyp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTyp;

	private String nazwaTypu;

	@Lob
	private String opisTypu;

	//bi-directional many-to-one association to Zwierze
	@OneToMany(mappedBy="zwierzetyp")
	private List<Zwierze> zwierzes;

	public Zwierzetyp() {
	}

	public int getIdTyp() {
		return this.idTyp;
	}

	public void setIdTyp(int idTyp) {
		this.idTyp = idTyp;
	}

	public String getNazwaTypu() {
		return this.nazwaTypu;
	}

	public void setNazwaTypu(String nazwaTypu) {
		this.nazwaTypu = nazwaTypu;
	}

	public String getOpisTypu() {
		return this.opisTypu;
	}

	public void setOpisTypu(String opisTypu) {
		this.opisTypu = opisTypu;
	}

	public List<Zwierze> getZwierzes() {
		return this.zwierzes;
	}

	public void setZwierzes(List<Zwierze> zwierzes) {
		this.zwierzes = zwierzes;
	}

	public Zwierze addZwierze(Zwierze zwierze) {
		getZwierzes().add(zwierze);
		zwierze.setZwierzetyp(this);

		return zwierze;
	}

	public Zwierze removeZwierze(Zwierze zwierze) {
		getZwierzes().remove(zwierze);
		zwierze.setZwierzetyp(null);

		return zwierze;
	}

}