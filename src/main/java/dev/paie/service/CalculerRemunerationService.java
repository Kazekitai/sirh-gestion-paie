package dev.paie.service;

import org.springframework.stereotype.Service;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * Interface du service de calcul de rémunération
 * @author Sandra Le Thiec
 *
 */
@Service
public interface CalculerRemunerationService {
	/**
	 * Calculer une rémunération
	 * @param bulletin
	 * @return
	 */
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
}
