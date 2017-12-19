package dev.paie.service;

import java.util.List;
import dev.paie.entite.Cotisation;

/**
 * Interface pour le service de cotisation
 * @author Sandra Le Thiec
 *
 */

public interface CotisationService {
	/**
	 * Sauvegarder une cotisation
	 * @param nouvelleCotisation
	 */
	void sauvegarder(Cotisation nouvelleCotisation);
	
	/**
	 * Mettre à jour une cotisation
	 * @param cotisation
	 */
	void mettreAJour(Cotisation cotisation);
	
	/**
	 * Lister les cotisations
	 * @return
	 */
	List<Cotisation> lister();

}
