package dev.paie.entite;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Avantages
 * @author Sandra Le Thiec
 *
 */
@Component
public class Avantage {

	/* ATTRIBUTS */
	/**
	 * Un identifiant
	 */
	private Integer id;
	
	/**
	 * Un code avantage
	 */
	private String code;
	
	/**
	 * Un nom définissant l'avantage
	 */
	private String nom;
	
	/**
	 * Un montant de l'avantage
	 */
	private BigDecimal montant;

	
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
