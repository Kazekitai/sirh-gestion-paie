package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.Utilisateur;

/**
 * Interface repository pour les utilisateurs
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
