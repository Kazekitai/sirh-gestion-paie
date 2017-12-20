package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.exception.SaisieException;
import dev.paie.repository.CotisationRepository;

@Controller
public class AjouterCotisation extends OptionMenu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);
	private final Logger LOGGER = LoggerFactory.getLogger("logger2");
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");
	@Autowired
	private CotisationRepository cotisationRepository;



	/* METHODS */

	/**
	 * Method Execute
	 */
	public boolean execute()  {
		try {
			return displayMenu2();
		} catch (SaisieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Ajouter une cotisation";
	}

	/**
	 * Display menu 2 to add pizza
	 * @throws SaisieException 
	 */
	public boolean displayMenu2() throws SaisieException  {
		LOGINFO.trace("\nCréer une cotisation");
		LOGINFO.trace("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		if (code.isEmpty()) {
			LOGGER.error("Erreur le code de la cotisation est vide");
			throw new SaisieException("Erreur le code de la cotisation est vide");

		}


		LOGINFO.trace("Veuillez saisir le libellé: ");
		String libelle = scanner.nextLine();

		if (libelle.isEmpty()) {
			LOGGER.error("Erreur le libellé de la cotisation est vide ");
			throw new SaisieException("Erreur le libellé de la cotisation est vide ");
		}

		
		LOGINFO.trace("Veuillez saisir le taux salarial: ");
		String tauxSalarial = scanner.nextLine();

		if (tauxSalarial.isEmpty()) {
			LOGGER.error("Erreur le taux salarial de la cotisation est vide");
			throw new SaisieException("Erreur le taux salarial de la cotisation est vide");
		}
		
		LOGINFO.trace("Veuillez saisir le taux patronal: ");
		String tauxPatronal = scanner.nextLine();

		if (tauxPatronal.isEmpty()) {
			LOGGER.error("Erreur le taux patronal de la cotisation est vide");
			throw new SaisieException("Erreur le taux patronal de la cotisation est vide");
		}
		Cotisation nouvelleCotisation = new Cotisation();
		nouvelleCotisation.setCode(code);
		nouvelleCotisation.setLibelle(libelle);
		nouvelleCotisation.setTauxSalarial(new BigDecimal(tauxSalarial));
		nouvelleCotisation.setTauxPatronal(new BigDecimal(tauxPatronal));
		cotisationRepository.save(nouvelleCotisation);
		return true;
		
	}

}
