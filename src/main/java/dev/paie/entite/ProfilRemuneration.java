package dev.paie.entite;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Un profil de rémunération
 * @author Sandra Le Thiec
 *
 */
@Component
public class ProfilRemuneration {

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
	 * Une liste des cotisations non imposables
	 */
	private List<Cotisation> cotisationsNonImposables;
	
	/**
	 * Une liste des cotisations imposables
	 */
	private List<Cotisation> cotisationsImposables;
	
	/**
	 * Une liste des avantages
	 */
	private List<Avantage> avantages;

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
	 * @return the cotisationsNonImposables
	 */
	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	/**
	 * @param cotisationsNonImposables the cotisationsNonImposables to set
	 */
	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	/**
	 * @return the cotisationsImposables
	 */
	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	/**
	 * @param cotisationsImposables the cotisationsImposables to set
	 */
	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	/**
	 * @return the avantages
	 */
	public List<Avantage> getAvantages() {
		return avantages;
	}

	/**
	 * @param avantages the avantages to set
	 */
	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
