package dev.paie.web.listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesServiceDev;

/**
 * Ecouteur pour initialiser les données dans la base au lancement de
 * l'application
 * 
 * @author Sandra Le Thiec
 *
 */
@Component
public class InitialiserDonneesListener {

	/* ATTRIBUTS */
	/**
	 * Service d'initialisation des données dans la base
	 */
	@Autowired
	private InitialiserDonneesServiceDev initialiserDonneesServiceDev;

	/* METHODES */

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		initialiserDonneesServiceDev.initialiser();
	}

}
