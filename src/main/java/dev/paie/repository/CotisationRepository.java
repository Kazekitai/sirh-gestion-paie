package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.Cotisation;

/**
 * Interface repository pour les cotisations
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface CotisationRepository extends JpaRepository<Cotisation, Integer> {
	List<Cotisation> findByCode(String code);

}
