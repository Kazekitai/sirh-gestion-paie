package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Classe utilisateur
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "UTILISATEUR")
@Component
public class Utilisateur {
	
	/* ATTRIBUTS */
	public enum ROLES {	ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR}
	
	/**
	 * Un identifiant
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Un nom d'utilisateur
	 */
	@Column(name="NOM_UTILISATEUR")
	private String nomUtilisateur;
	
	/**
	 * Un mot de passe
	 */
	@Column(name="MOT_DE_PASSE")
	private String motDePasse;
	
	/**
	 * Un statut : actif ou non
	 */
	@Column(name="EST_ACTIF")
	private String estActif;
	
	/**
	 * Un rôle
	 */
	@Enumerated(EnumType.STRING)
	private ROLES role;

	
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
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the estActif
	 */
	public String getEstActif() {
		return estActif;
	}

	/**
	 * @param estActif the estActif to set
	 */
	public void setEstActif(String estActif) {
		this.estActif = estActif;
	}

	/**
	 * @return the role
	 */
	public ROLES getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(ROLES role) {
		this.role = role;
	}
	
	
	

}
