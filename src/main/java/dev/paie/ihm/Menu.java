package dev.paie.ihm;

import java.util.HashMap;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Menu {
	/* ATTRIBUTS */
	private Scanner scanner = new Scanner(System.in);
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");


	// private PizzaDao dao = new PizzaDao();
	private String title;
	private HashMap<Integer, OptionMenu> optionMenus = new HashMap<Integer, OptionMenu>();
	private static final int LISTER_COTISATIONS = 0;
	private static final int AJOUTER_COTISATION = 1;
	private static final int SUPPRIMER_COTISATION = 2;
	
	@Autowired private ListerCotisation listerCotisation;
	@Autowired private AjouterCotisation ajouterCotisation;
	@Autowired private SupprimerCotisation supprimerCotisation;

	/* CONSTRUCTOR */
	/**
	 * Constructor
	 */
	public Menu() {
	
	}

	
	@PostConstruct
	public void init() {
		title = "***** Gestion des cotisations *****";
		optionMenus.put(LISTER_COTISATIONS, listerCotisation);
		optionMenus.put(AJOUTER_COTISATION, ajouterCotisation);
		optionMenus.put(SUPPRIMER_COTISATION, supprimerCotisation);
	}
	

	/**
	 * Methode pour lancer l'application
	 */
	public void afficher() {
		int option = 0;
		/* Run application */
		while (option != 99) {
			displayMenu();
			option = Integer.parseInt(scanner.nextLine());
			switch (option) {
			case 1:	optionMenus.get(LISTER_COTISATIONS).execute();
				break;
			case 2: optionMenus.get(AJOUTER_COTISATION).execute();
				break;
			case 3: optionMenus.get(SUPPRIMER_COTISATION).execute();
				break;
			case 99:
				LOGINFO.trace("\nAu revoir " + ":(");
				break;
			default:
				LOGINFO.trace("\nCette option n'existe pas!");
				break;
			}
		}
		scanner.close();
	}

	/**
	 * Methode pour afficher le menu
	 */
	public void displayMenu() {
		LOGINFO.trace("\n" + this.title);
		for (int i = 0; i < optionMenus.size() ; i++) {
			if (optionMenus.get(i) != null) {
				LOGINFO.trace((i + 1) + ". " + optionMenus.get(i).getLabel());
			}
		}
		LOGINFO.trace("99. Sortir.");
		LOGINFO.trace("Quelle action voulez-vous effectuer?");
	}
	
	

	/* GETTER */
	public HashMap<Integer, OptionMenu> getOptionMenus() {
		return optionMenus;
	}

}
