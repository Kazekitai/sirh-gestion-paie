package dev.paie.entite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Une rémunération pour un employé
 * @author Sandra Le Thiec
 *
 */
@Component
public class RemunerationEmploye {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	private Integer id;
	
	/**
	 * Un matricule
	 */
	private String matricule;
	
	/**
	 * Une entreprise
	 */
	@Autowired
	private Entreprise entreprise;
	
	/**
	 * Un profil de rémunération
	 */
	@Autowired
	private ProfilRemuneration profilRemuneration;
	
	/**
	 * Un grade
	 */
	@Autowired
	private Grade grade;

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
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the entreprise
	 */
	public Entreprise getEntreprise() {
		return entreprise;
	}

	/**
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * @return the profilRemuneration
	 */
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	/**
	 * @param profilRemuneration the profilRemuneration to set
	 */
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
