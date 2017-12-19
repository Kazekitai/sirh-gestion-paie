package dev.paie.entite;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Une cotisation
 * @author Sandra Le Thiec
 *
 */
@Component
public class Cotisation {
	
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
	 * Un libellé
	 */
	private String libelle;
	
	/**
	 * Un taux salarial
	 */
	private BigDecimal tauxSalarial;
	
	/**
	 * Un taux patronal
	 */
	private BigDecimal tauxPatronal;
	
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
