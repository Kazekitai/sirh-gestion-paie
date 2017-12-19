package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.util.PaieUtils;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	private final Logger LOG = LoggerFactory.getLogger("logger1");

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private PaieUtils paieUtils;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouveau grade
		Grade nouveauGrade = new Grade();
		nouveauGrade.setCode("5");
		nouveauGrade.setNbHeuresBase(new BigDecimal("151.67"));
		nouveauGrade.setTauxBase(new BigDecimal("11.0984"));
		gradeService.sauvegarder(nouveauGrade);
		
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> grades = gradeService.lister();
		Grade grade = grades.get(grades.size()-1);
		assertThat(grade.getCode().equals("5")).as("verification code " + grade.getCode()).isTrue();
		assertThat(paieUtils.formaterBigDecimal(grade.getNbHeuresBase()).equals(paieUtils.formaterBigDecimal(new BigDecimal("151.67"))));
		assertThat(paieUtils.formaterBigDecimal(grade.getTauxBase()).equals(paieUtils.formaterBigDecimal(new BigDecimal("11.0984"))));
		LOG.info("Grade ajouté: " + grade.toString());
		
		
	// TODO modifier un grade
		// Récupération du grade à modifier (pour le test on modifie le dernier grade ajouté)
		Grade gradeModif = grades.get(grades.size()-1);
		gradeModif.setCode("6");
		gradeModif.setNbHeuresBase(new BigDecimal("200.67"));
		gradeModif.setTauxBase(new BigDecimal("15.0984"));
		gradeService.mettreAJour(gradeModif);
		
		
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		List<Grade> gradesModif = gradeService.lister();
		Grade gradeModifRecup = gradesModif.get(grades.size()-1);
		assertThat(gradeModifRecup.getCode().equals("6")).as("verification code " + gradeModifRecup.getCode()).isTrue();
		assertThat(paieUtils.formaterBigDecimal(gradeModifRecup.getNbHeuresBase()).equals(paieUtils.formaterBigDecimal(new BigDecimal("200.67"))));
		assertThat(paieUtils.formaterBigDecimal(gradeModifRecup.getTauxBase()).equals(paieUtils.formaterBigDecimal(new BigDecimal("15.0984"))));
		LOG.info("Grade modifié: " + gradeModifRecup.toString());
	}

}
