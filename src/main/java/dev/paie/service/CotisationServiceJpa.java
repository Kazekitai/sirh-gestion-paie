package dev.paie.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.Cotisation;

@Service
@Transactional
public class CotisationServiceJpa implements CotisationService {
	/* ATTRIBUTS */
	
	/**
	 * Un entityManager
	 */
	@PersistenceContext private EntityManager em;
	
	/* METHODES */

	/**
	 * Sauvegarder une cotisation
	 * @param nouvelleCotisation
	 */
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	/**
	 * Mettre à jour une cotisation
	 * @param cotisation
	 */
	@Override
	public void mettreAJour(Cotisation cotisation) {
		em.merge(cotisation);
		
	}

	/**
	 * Lister les cotisations
	 * @return
	 */
	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("select c from Cotisation c", Cotisation.class);
		return query.getResultList();
	}

}
