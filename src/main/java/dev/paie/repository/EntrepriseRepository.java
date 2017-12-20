package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.Entreprise;

/**
 * Interface repository pour les entreprises
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
