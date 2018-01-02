package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.UtilisateurRepository;

//Marque un bean de configuration Spring
@Configuration
//Import de la configuration XML dans une configuration Java
@ImportResource({"classpath:cotisations-imposables.xml", 
	"classpath:cotisations-non-imposables.xml",
	"classpath:entreprises.xml",
	"classpath:grades.xml","classpath:profils-remuneration.xml"})

public class InitialiserDonneesServiceDev implements InitialiserDonneesService{
	
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private UtilisateurRepository utilisteurRepository;
	@Autowired private CotisationRepository cotisationRepository;
	@Autowired private GradeRepository gradeRepository;
	@Autowired private EntrepriseRepository entrepriseRepository;
	@Autowired private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired private PeriodeRepository periodeRepository;
	@Autowired private List<Entreprise> entreprises;
	@Autowired private List<Grade> grades;
	@Autowired private List<Cotisation> cotisations;
	@Autowired private List<ProfilRemuneration> profils;
	
	@Override
	public void initialiser() {

		//Insertion des entreprises dans la base
		entreprises.stream().forEach(e -> entrepriseRepository.save(e));
	
		// Insertion des grades dans la base
		grades.stream().forEach(e -> gradeRepository.save(e));
	
		// Insertion des cotisations dans la base
		cotisations.stream().forEach(e -> cotisationRepository.save(e));
		
		// Insertion des profils de rémunération dans la base
		profils.stream().forEach(e -> profilRemunerationRepository.save(e));
		
		// Insertion des périodes dans la base
		for(int i=0; i<12;i++) {
			LocalDate date = LocalDate.of(LocalDate.now().getYear(), i+1, 1);
			LocalDate start = date.with(TemporalAdjusters.firstDayOfMonth());
			LocalDate end = date.with(TemporalAdjusters.lastDayOfMonth());
			Periode p = new Periode();
			p.setDateDebut(start);
			p.setDateFin(end);
			periodeRepository.save(p);
		}
		
		// Insertion d'un utilisateur dans la base
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEstActif("true");
		utilisateur.setNomUtilisateur("Bernard");
		utilisateur.setMotDePasse(this.passwordEncoder.encode("123"));
		utilisateur.setRole(Utilisateur.ROLES.ROLE_UTILISATEUR);
		utilisteurRepository.save(utilisateur);
		
		// Insertion d'un administrateur dans la base
		Utilisateur admin = new Utilisateur();
		admin.setEstActif("true");
		admin.setNomUtilisateur("Sandra");
		admin.setMotDePasse(this.passwordEncoder.encode("admin"));
		admin.setRole(Utilisateur.ROLES.ROLE_ADMINISTRATEUR);
		utilisteurRepository.save(admin);
		
	}

}
