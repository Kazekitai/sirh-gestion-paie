package dev.paie.service;

import java.util.List;
import dev.paie.entite.Grade;

/**
 * Interface du service pour les grades
 * @author Sandra Le Thiec
 *
 */
public interface GradeService {
	/**
	 * Sauvegarder un grade
	 * @param nouveauGrade
	 */
	void sauvegarder(Grade nouveauGrade);
	
	/**
	 * Mettre un jour un grade
	 * @param grade
	 */
	void mettreAJour(Grade grade);
	
	/**
	 * Lister les grades
	 * @return
	 */
	List<Grade> lister();
}
