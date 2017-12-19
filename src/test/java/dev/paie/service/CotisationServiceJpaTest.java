package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.util.PaieUtils;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	private final Logger LOG = LoggerFactory.getLogger("logger1");

	@Autowired
	private CotisationService cotisationService;
	
	@Autowired
	private PaieUtils paieUtils;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		Cotisation nouvelleCotisation = new Cotisation();
		nouvelleCotisation.setCode("SP32");
		nouvelleCotisation.setLibelle("URSSAF UUU");
		nouvelleCotisation.setTauxSalarial(new BigDecimal("0.005000"));
		nouvelleCotisation.setTauxPatronal(new BigDecimal("0.024000"));
		cotisationService.sauvegarder(nouvelleCotisation);
		
		
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		List<Cotisation> cotisations = cotisationService.lister();
		Cotisation cotisation = cotisations.get(cotisations.size()-1);
		assertThat(cotisation.getCode().equals("SP32")).as("verification code " + cotisation.getCode()).isTrue();
		assertThat(cotisation.getLibelle().equals("URSSAF UUU"));
		assertThat(paieUtils.formaterBigDecimal(cotisation.getTauxSalarial()).equals(paieUtils.formaterBigDecimal(new BigDecimal("0.005000"))));
		assertThat(paieUtils.formaterBigDecimal(cotisation.getTauxPatronal()).equals(paieUtils.formaterBigDecimal(new BigDecimal("0.024000"))));
		LOG.info("\nCotisation ajoutée: " + cotisation.toString());
		
		// TODO modifier une cotisation
		Cotisation cotisationModif = cotisations.get(cotisations.size()-1);
		cotisationModif.setCode("SP32Modif");
		cotisationModif.setLibelle("URSSAF AAAA");
		cotisationModif.setTauxSalarial(new BigDecimal("0.009000"));
		cotisationModif.setTauxPatronal(new BigDecimal("0.009000"));
		cotisationService.mettreAJour(cotisationModif);
		
		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		List<Cotisation> cotisationsModif = cotisationService.lister();
		Cotisation cotisationModifRecup = cotisationsModif.get(cotisations.size()-1);
		assertThat(cotisationModifRecup.getCode().equals("SP32Modif")).as("verification code " + cotisation.getCode()).isTrue();
		assertThat(cotisationModifRecup.getLibelle().equals("URSSAF AAAA"));
		assertThat(paieUtils.formaterBigDecimal(cotisationModifRecup.getTauxSalarial()).equals(paieUtils.formaterBigDecimal(new BigDecimal("0.009000"))));
		assertThat(paieUtils.formaterBigDecimal(cotisationModifRecup.getTauxPatronal()).equals(paieUtils.formaterBigDecimal(new BigDecimal("0.009000"))));
		LOG.info("\nCotisation modifiée: " + cotisationModifRecup.toString());
	}

}
