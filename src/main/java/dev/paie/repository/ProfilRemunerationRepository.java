package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.ProfilRemuneration;

/**
 * Interface repository pour les profils de rémunération
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, Integer> {

}
