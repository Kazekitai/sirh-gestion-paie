package dev.paie.web.ecouteur;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dev.paie.service.InitialiserDonneesServiceDev;

/**
 * Ecouteur pour initialiser les données dans la base au lancement de l'application
 * @author Sandra Le Thiec
 *
 */
public class InitialiserDonneesListener implements ServletContextListener {

	private InitialiserDonneesServiceDev initialiserDonneesServiceDev;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		initialiserDonneesServiceDev.initialiser();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
