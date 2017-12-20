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
public class ListerCotisation extends OptionMenu  {
	
	/* ATTRIBUTS */
	Scanner scanner = new Scanner(System.in);
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");
	
	@Autowired
	private CotisationRepository cotisationRepository;
	
	/* METHODES */

	/**
	 * Méthode Execute
	 */
	public boolean execute()  {
		return displayMenu1();
	}

	/**
	 * récupérer le label de l'option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Lister les cotisations";
	}
	
	/**
	 * Afficher menu 1 pour lister les cotisations
	 */
	public boolean displayMenu1() {
		List<Cotisation> cotisations = cotisationRepository.findAll();
		
		if(cotisations == null) {
			LOGINFO.trace("\nListe des cotisations (0 cotisation)\n");
		} else {
			LOGINFO.trace("\nListe des cotisations (" + cotisations.size() + " cotisations)\n");
			cotisations.stream().forEach(c -> LOGINFO.trace(c.toString()));
		}
		
		return true;
	}

}
