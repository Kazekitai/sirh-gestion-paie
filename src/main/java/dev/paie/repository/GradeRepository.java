package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.paie.entite.Grade;

/**
 * Interface repository pour les grades
 * 
 * @author Sandra Le Thiec
 *
 */
public interface GradeRepository  extends JpaRepository<Grade, Integer> {

}
