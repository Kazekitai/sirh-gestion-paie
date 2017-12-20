package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Une cotisation
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "cotisation")
@Component
public class Cotisation {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Un code
	 */
	@Column(name="code")
	private String code;
	
	/**
	 * Un libellé
	 */
	@Column(name="libelle")
	private String libelle;
	
	/**
	 * Un taux salarial
	 */
	@Column(name="tauxSalarial")
	private BigDecimal tauxSalarial;
	
	/**
	 * Un taux patronal
	 */
	@Column(name="tauxPatronal")
	private BigDecimal tauxPatronal;
	
	
	/* METHODE */
	public String toString() {
		return "Code: " + code + " - Libellé: " + libelle + " - Taux salarial: " + tauxSalarial + " - Taux salarial: " + tauxPatronal;
	}
	
	/* GETTERS ET SETTERS */

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the tauxSalarial
	 */
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	/**
	 * @param tauxSalarial the tauxSalarial to set
	 */
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	/**
	 * @return the tauxPatronal
	 */
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	/**
	 * @param tauxPatronal the tauxPatronal to set
	 */
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

}