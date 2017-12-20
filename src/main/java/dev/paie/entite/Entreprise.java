package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Une entreprise
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "entreprise")
@Component
public class Entreprise {

	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Un siret
	 */
	@Column(name="siret")
	private String siret;
	
	/**
	 * Une dénomnation
	 */
	@Column(name="denomination")
	private String denomination;
	
	/**
	 * Une addresse
	 */
	@Column(name="adresse")
	private String adresse;
	
	/**
	 * Un code Ursaff
	 */
	@Column(name="urssaf")
	private String urssaf;
	
	/**
	 * Un code Naf
	 */
	@Column(name="codeNaf")
	private String codeNaf;
	
	@OneToMany(mappedBy="entreprise")
	private List<RemunerationEmploye> remunerationsEmp;

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