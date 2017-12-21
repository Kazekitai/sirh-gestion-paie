package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Une rémunération pour un employé
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name="remunerationEmploye")
@Component
public class RemunerationEmploye {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Un matricule
	 */
	@Column(name="matricule")
	private String matricule;
	
	/**
	 * Une entreprise
	 */
	@Autowired
	@ManyToOne
	@JoinColumn(name="entreprise_id")
	private Entreprise entreprise;
	
	/**
	 * Un profil de rémunération
	 */
	@Autowired
	@ManyToOne
	@JoinColumn(name="profil_id")
	private ProfilRemuneration profilRemuneration;
	
	/**
	 * Un grade
	 */
	@Autowired
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	/**
	 * Une date de création
	 */
	@Column(name="dateCreation")
	private LocalDateTime dateCreation;
	

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

	/**
	 * @return the dateCreation
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
}