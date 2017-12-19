package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.util.PaieUtils;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	private final Logger LOG = LoggerFactory.getLogger("logger1");

	@Autowired
	private AvantageRepository avantageRepository;
	
	@Autowired
	private PaieUtils paieUtils;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		avantage.setCode("CF");
		avantage.setMontant(new BigDecimal("150.20"));
		avantage.setNom("repas");
		Avantage newAvantage = avantageRepository.save(avantage);
		
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage newAvantageRecup = avantageRepository.findOne(newAvantage.getId());
		assertThat(newAvantageRecup.getCode().equals("CF"));
		assertThat(newAvantageRecup.getNom().equals("repas"));
		assertThat(paieUtils.formaterBigDecimal(newAvantageRecup.getMontant()).equals(paieUtils.formaterBigDecimal(new BigDecimal("150.20"))));
		LOG.info("\nAvantage ajouté: " + newAvantageRecup.toString());
		
	// TODO modifier un avantage
		newAvantageRecup.setCode("CFModif");
		newAvantageRecup.setMontant(new BigDecimal("500.50"));
		newAvantageRecup.setNom("déjeuner");
		Avantage avantageModif = avantageRepository.save(newAvantageRecup);
		
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
		Avantage avantageModifRecup = avantageRepository.findOne(avantageModif.getId());
		assertThat(avantageModifRecup.getCode().equals("CFModif"));
		assertThat(avantageModifRecup.getNom().equals("déjeuner"));
		assertThat(paieUtils.formaterBigDecimal(avantageModifRecup.getMontant()).equals(paieUtils.formaterBigDecimal(new BigDecimal("500.50"))));
		LOG.info("\nAvantage modifié: " + avantageModifRecup.toString());
		
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findByCode
			Avantage avantageModifRecupByCode = avantageRepository.findByCode(avantageModifRecup.getCode()).get(0);
			assertThat(avantageModifRecupByCode.getCode().equals("CFModif"));
			assertThat(avantageModifRecupByCode.getNom().equals("déjeuner"));
			assertThat(paieUtils.formaterBigDecimal(avantageModifRecupByCode.getMontant()).equals(paieUtils.formaterBigDecimal(new BigDecimal("500.50"))));
			LOG.info("\nAvantage modifié (recherche par code): " + avantageModifRecupByCode.toString());
	}

}
