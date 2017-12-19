package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * Service pour calculer une rémunération
 * @author Sandra Le Thiec
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	/* ATTRIBUTS */
	
	/**
	 * Accès aus ervices utiles. Ici, pour la conversion des BigDecimal en String
	 */
	@Autowired
	private PaieUtils paieUtils;
	
	/* METHODES */
	
	/**
	 * Calculer une rémunération
	 * @return ResultatCalculRemuneration
	 */
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		// Calcul du salaire brut
		BigDecimal salaireDeBaseBD = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply( bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		String salaireDeBase = paieUtils.formaterBigDecimal(salaireDeBaseBD);
		
		BigDecimal salaireBrutBD = salaireDeBaseBD.add(bulletin.getPrimeExceptionnelle());
		String salaireBrut = paieUtils.formaterBigDecimal(salaireBrutBD);
		
		// Calcul du total de la retenue salariale
		List<Cotisation> cotisationNonImposable = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		BigDecimal totalRetenueSalarialBD = BigDecimal.valueOf(0.0);
		for(Cotisation cotisation : cotisationNonImposable) {
			if(cotisation.getTauxSalarial() != null) {
				BigDecimal res = cotisation.getTauxSalarial().multiply(new BigDecimal(salaireBrut));
				totalRetenueSalarialBD = totalRetenueSalarialBD.add(res);
			}
		}
		String totalRetenueSalarial = paieUtils.formaterBigDecimal(totalRetenueSalarialBD);
		
		// Calcul du total de la cotisation patronale
		BigDecimal sommePatronales = BigDecimal.valueOf(0.0);
		for(Cotisation cotisation : cotisationNonImposable) {
			if(cotisation.getTauxPatronal() != null) {
				BigDecimal res = cotisation.getTauxPatronal().multiply(new BigDecimal(salaireBrut));
				sommePatronales = sommePatronales.add(res);
			}
		}
		String totalCotisationsPatronales = paieUtils.formaterBigDecimal(sommePatronales);
		
		// Calcul de la rémunération net imposable
		BigDecimal netImposableBD = new BigDecimal(salaireBrut).subtract(new BigDecimal(totalRetenueSalarial));
		String netImposable = paieUtils.formaterBigDecimal(netImposableBD);
		
		// Calcul de la rémunération net à payer
		List<Cotisation> cotisationImposable = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		BigDecimal totalRetenueSalarialImposableBD = BigDecimal.valueOf(0.0);
		for(Cotisation cotisation : cotisationImposable) {
			BigDecimal res = cotisation.getTauxSalarial().multiply(new BigDecimal(salaireBrut));
			totalRetenueSalarialImposableBD = totalRetenueSalarialImposableBD.add(res);		
		}
		BigDecimal netAPayerBD = netImposableBD.subtract(totalRetenueSalarialImposableBD);
		String netAPayer = paieUtils.formaterBigDecimal(netAPayerBD);
		
		// mapping des résultats dans l'objet correspondant ResultatCalculRemuneration
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		resultat.setSalaireDeBase(salaireDeBase);
		resultat.setNetAPayer(netAPayer);
		resultat.setNetImposable(netImposable);
		resultat.setSalaireBrut(salaireBrut);
		resultat.setTotalCotisationsPatronales(totalCotisationsPatronales);
		resultat.setTotalRetenueSalarial(totalRetenueSalarial);
		
		return resultat;
	}

}
