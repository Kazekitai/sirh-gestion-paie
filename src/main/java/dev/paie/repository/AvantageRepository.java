package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Avantage;

/**
 * Interface repository pour les avantages
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface AvantageRepository extends JpaRepository<Avantage, Integer> {
	List<Avantage> findByCode(String code);

}