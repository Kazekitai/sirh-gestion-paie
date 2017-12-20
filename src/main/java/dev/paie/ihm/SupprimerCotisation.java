package dev.paie.ihm;

import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Controller
public class SupprimerCotisation extends OptionMenu {
	/* ATTRIBUTS */
	Scanner scanner = new Scanner(System.in);
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");
	@Autowired
	private CotisationRepository cotisationRepository;
	
	/* METHODES */

	/**
	 * Methode Execute
	 */
	public boolean execute()  {
		return displayMenu3();
	}

	/**
	 * récupérer le label de l'option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Supprimer une cotisation";
	}
	
	/**
	 * Afficher menu 3 pour supprimer une cotisation
	 */
	public boolean displayMenu3() {
		LOGINFO.trace("\nSupression d'une cotisation");
		super.displayCotisationsList();
		LOGINFO.trace("99 pour abandonner");
		LOGINFO.trace("Veuillez choisir la cotisation à supprimer (saisir le code) : ");
		String choice = scanner.nextLine();
		if (!choice.equals("99")) {
			Cotisation cotisationASuppr = cotisationRepository.findByCode(choice).get(0);
			cotisationRepository.delete(cotisationASuppr);
			return true;
		} else {
			return false;
		}
	}

}
