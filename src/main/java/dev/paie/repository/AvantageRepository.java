package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.paie.entite.Avantage;

/**
 * Interface repository pour les avantages
 * @author Sandra Le Thiec
 *
 */
@Repository
public interface AvantageRepository extends JpaRepository<Avantage, Integer> {
	
	Avantage findOne(String code);

}
