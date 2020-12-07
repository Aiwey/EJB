package schronisko.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rodzina database table.
 * 
 */
@Entity
@NamedQuery(name="Rodzina.findAll", query="SELECT r FROM Rodzina r")
public class Rodzina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRodzina;

	private String email;

	private String imie;

	private String miasto;

	private String nazwisko;

	private String nrDomu;

	private String nrMieszkania;

	private String telefon;

	private String ulica;

	//bi-directional many-to-one association to Adopcja
	@OneToMany(mappedBy="rodzina")
	private List<Adopcja> adopcjas;

	public Rodzina() {
	}

	public int getIdRodzina() {
		return this.idRodzina;
	}

	public void setIdRodzina(int idRodzina) {
		this.idRodzina = idRodzina;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrDomu() {
		return this.nrDomu;
	}

	public void setNrDomu(String nrDomu) {
		this.nrDomu = nrDomu;
	}

	public String getNrMieszkania() {
		return this.nrMieszkania;
	}

	public void setNrMieszkania(String nrMieszkania) {
		this.nrMieszkania = nrMieszkania;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public List<Adopcja> getAdopcjas() {
		return this.adopcjas;
	}

	public void setAdopcjas(List<Adopcja> adopcjas) {
		this.adopcjas = adopcjas;
	}

	public Adopcja addAdopcja(Adopcja adopcja) {
		getAdopcjas().add(adopcja);
		adopcja.setRodzina(this);

		return adopcja;
	}

	public Adopcja removeAdopcja(Adopcja adopcja) {
		getAdopcjas().remove(adopcja);
		adopcja.setRodzina(null);

		return adopcja;
	}

}