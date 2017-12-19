package dev.paie.entite;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Un grade
 * @author Le Thiec Sandra
 *
 */
@Component
public class Grade {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	private Integer id;
	
	/**
	 * Un code
	 */
	private String code;
	
	/**
	 * Un nombre d'heures de base
	 */
	private BigDecimal nbHeuresBase;
	
	/**
	 * Un taux de base
	 */
	private BigDecimal tauxBase;
	
	/* METHODES */
	
	/**
	 * Convertir l'objet en chaîne de caractère
	 */
	public String toString() {
		return "Code: " + code +" - Nb heures de base: " + nbHeuresBase +" - Taux de base: "+ tauxBase;	
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
	 * @return the nbHeuresBase
	 */
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}

	/**
	 * @param nbHeuresBase the nbHeuresBase to set
	 */
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	/**
	 * @return the tauxBase
	 */
	public BigDecimal getTauxBase() {
		return tauxBase;
	}

	/**
	 * @param tauxBase the tauxBase to set
	 */
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	
	
	
	

}
