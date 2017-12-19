package dev.paie.repository;

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

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	private final Logger LOG = LoggerFactory.getLogger("logger1");

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		avantage.setCode("CF");
		avantage.setMontant(new BigDecimal("150"));
		avantage.setNom("repas");
		avantageRepository.save(avantage);
		
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage newAvantage = avantageRepository.findOne(avantage.getCode());
		LOG.info(newAvantage.toString());
		
	// TODO modifier un avantage
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	}

}
