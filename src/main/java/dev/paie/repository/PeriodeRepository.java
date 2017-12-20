package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.Periode;

/**
 * Interface repository pour les périodes
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

}
