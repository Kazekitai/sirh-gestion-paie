package dev.paie.entite;

import org.springframework.stereotype.Component;

/**
 * Une entreprise
 * @author Sandra Le Thiec
 *
 */
@Component
public class Entreprise {

	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	private Integer id;
	
	/**
	 * Un siret
	 */
	private String siret;
	
	/**
	 * Une dénomnation
	 */
	private String denomination;
	
	/**
	 * Une addresse
	 */
	private String adresse;
	
	/**
	 * Un code Ursaff
	 */
	private String urssaf;
	
	/**
	 * Un code Naf
	 */
	private String codeNaf;

	/* GETTERS ET SETTERS  */
	
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
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

	/**
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * @param denomination the denomination to set
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the urssaf
	 */
	public String getUrssaf() {
		return urssaf;
	}

	/**
	 * @param urssaf the urssaf to set
	 */
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}

	/**
	 * @return the codeNaf
	 */
	public String getCodeNaf() {
		return codeNaf;
	}

	/**
	 * @param codeNaf the codeNaf to set
	 */
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}
	
	
	
	
}
