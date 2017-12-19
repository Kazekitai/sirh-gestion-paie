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
 * Avantages
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "avantage")
@Component
public class Avantage {

	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Un code avantage
	 */
	@Column(name="code")
	private String code;
	
	/**
	 * Un nom définissant l'avantage
	 */
	@Column(name="nom")
	private String nom;
	
	/**
	 * Un montant de l'avantage
	 */
	@Column(name="montant")
	private BigDecimal montant;
	
	/* METHODES */
	public String toString() {
		return "Code: " + code + " - Nom: " + nom + " - montant: " + montant;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	
	
}
