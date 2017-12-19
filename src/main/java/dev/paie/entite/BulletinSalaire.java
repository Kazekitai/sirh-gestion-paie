package dev.paie.entite;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Un bulletin de salaire
 * @author Sandra Le Thiec
 *
 */
@Component
public class BulletinSalaire {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	private Integer id;
	
	/**
	 * Une rémunération. Injection de la dépendance RemunerationEmploye
	 */
	@Autowired
	private RemunerationEmploye remunerationEmploye;
	
	/**
	 * Une période
	 */
	private Periode periode;
	
	/**
	 * Un montant d'une prime exceptionnelle
	 */
	private BigDecimal primeExceptionnelle;

	
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
	 * @return the remunerationEmploye
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	/**
	 * @param remunerationEmploye the remunerationEmploye to set
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	/**
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}

	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	/**
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	/**
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	
	
	
	
	
}
