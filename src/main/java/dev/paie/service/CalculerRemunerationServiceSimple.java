package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	@Autowired
	private PaieUtils paieUtils;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		BigDecimal salaireDeBaseBD = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply( bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		String salaireDeBase = paieUtils.formaterBigDecimal(salaireDeBaseBD);
		
		BigDecimal salaireBrutBD = salaireDeBaseBD.add(bulletin.getPrimeExceptionnelle());
		String salaireBrut = paieUtils.formaterBigDecimal(salaireBrutBD);
		
		List<Cotisation> cotisationNonImposable = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		BigDecimal totalRetenueSalarialBD = new BigDecimal(0.0);
		for(Cotisation cotisation : cotisationNonImposable) {
			if(cotisation.getTauxSalarial() != null) {
				BigDecimal res = cotisation.getTauxSalarial().multiply(new BigDecimal(salaireBrut));
				totalRetenueSalarialBD = totalRetenueSalarialBD.add(res);
			}
		}
		String totalRetenueSalarial = paieUtils.formaterBigDecimal(totalRetenueSalarialBD);
		
		BigDecimal sommePatronales = new BigDecimal(0.0);
		for(Cotisation cotisation : cotisationNonImposable) {
			if(cotisation.getTauxPatronal() != null) {
				BigDecimal res = cotisation.getTauxPatronal().multiply(new BigDecimal(salaireBrut));
				sommePatronales = sommePatronales.add(res);
			}
		}
		String totalCotisationsPatronales = paieUtils.formaterBigDecimal(sommePatronales);
		
		BigDecimal netImposableBD = new BigDecimal(salaireBrut).subtract(new BigDecimal(totalRetenueSalarial));
		String netImposable = paieUtils.formaterBigDecimal(netImposableBD);
		
		List<Cotisation> cotisationImposable = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		BigDecimal totalRetenueSalarialImposableBD = new BigDecimal(0.0);
		for(Cotisation cotisation : cotisationImposable) {
			BigDecimal res = cotisation.getTauxSalarial().multiply(new BigDecimal(salaireBrut));
			totalRetenueSalarialImposableBD = totalRetenueSalarialImposableBD.add(res);		
		}
		BigDecimal netAPayerBD = netImposableBD.subtract(totalRetenueSalarialImposableBD);
		String netAPayer = paieUtils.formaterBigDecimal(netAPayerBD);
		
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
