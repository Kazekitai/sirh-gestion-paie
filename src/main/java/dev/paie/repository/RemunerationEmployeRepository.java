package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.RemunerationEmploye;

/**
 * Interface repository pour les employés
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface RemunerationEmployeRepository  extends JpaRepository<RemunerationEmploye, Integer> {

}
