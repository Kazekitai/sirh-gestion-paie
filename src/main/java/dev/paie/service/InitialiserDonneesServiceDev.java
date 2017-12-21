package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

//Marque un bean de configuration Spring
@Configuration
//Import de la configuration XML dans une configuration Java
@ImportResource({"classpath:cotisations-imposables.xml", 
	"classpath:cotisations-non-imposables.xml",
	"classpath:entreprises.xml",
	"classpath:grades.xml","classpath:profils-remuneration.xml"})

public class InitialiserDonneesServiceDev implements InitialiserDonneesService{
	
	@Autowired private CotisationRepository cotisationRepository;
	@Autowired private GradeRepository gradeRepository;
	@Autowired private EntrepriseRepository entrepriseRepository;
	@Autowired private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired private PeriodeRepository periodeRepository;
	
	@Autowired @Qualifier("grade1") private Grade grade1;
	@Autowired @Qualifier("grade2") private Grade grade2;
	@Autowired @Qualifier("grade3") private Grade grade3;
	
	@Autowired @Qualifier("entreprise1") private Entreprise entreprise1;
	@Autowired @Qualifier("entreprise2") private Entreprise entreprise2;
	@Autowired @Qualifier("entreprise3") private Entreprise entreprise3;
	
	@Autowired @Qualifier("sp01") private Cotisation sp01;
	@Autowired @Qualifier("sp02") private Cotisation sp02;
	
	@Autowired @Qualifier("ep01") private Cotisation ep01;
	@Autowired @Qualifier("ep02") private Cotisation ep02;
	@Autowired @Qualifier("ep03") private Cotisation ep03;
	@Autowired @Qualifier("ep04") private Cotisation ep04;
	@Autowired @Qualifier("ep05") private Cotisation ep05;
	@Autowired @Qualifier("ep06") private Cotisation ep06;
	@Autowired @Qualifier("ep07") private Cotisation ep07;
	@Autowired @Qualifier("ep12") private Cotisation ep12;
	@Autowired @Qualifier("ep14") private Cotisation ep14;
	@Autowired @Qualifier("ep19") private Cotisation ep19;
	@Autowired @Qualifier("ep20") private Cotisation ep20;
	@Autowired @Qualifier("ep21") private Cotisation ep21;
	@Autowired @Qualifier("ep28") private Cotisation ep28;
	@Autowired @Qualifier("ep37") private Cotisation ep37;
	@Autowired @Qualifier("epr1") private Cotisation epr1;
	@Autowired @Qualifier("epr2") private Cotisation epr2;
	@Autowired @Qualifier("e900") private Cotisation e900;
	@Autowired @Qualifier("e901") private Cotisation e901;
	
	@Autowired @Qualifier("profil-technicien") private ProfilRemuneration profilTechnicien;
	@Autowired @Qualifier("profil-cadre") private ProfilRemuneration profilCadre;
	@Autowired @Qualifier("profil-stagiaire") private ProfilRemuneration profilStagiaire;

	@Override
	public void initialiser() {
		
		//Insertion des entreprises dans la base
		entrepriseRepository.save(entreprise1);
		entrepriseRepository.save(entreprise2);
		entrepriseRepository.save(entreprise3);
		
		
		// Insertion des grades dans la base
		gradeRepository.save(grade1);
		gradeRepository.save(grade2);
		gradeRepository.save(grade3);
		
		// Insertion des cotisations dans la base
		cotisationRepository.save(sp01);
		cotisationRepository.save(sp02);
		cotisationRepository.save(ep01);
		cotisationRepository.save(ep02);
		cotisationRepository.save(ep03);
		cotisationRepository.save(ep04);
		cotisationRepository.save(ep05);
		cotisationRepository.save(ep06);
		cotisationRepository.save(ep07);
		cotisationRepository.save(ep12);
		cotisationRepository.save(ep14);
		cotisationRepository.save(ep19);
		cotisationRepository.save(ep20);
		cotisationRepository.save(ep21);
		cotisationRepository.save(ep28);
		cotisationRepository.save(ep37);
		cotisationRepository.save(epr1);
		cotisationRepository.save(epr2);
		cotisationRepository.save(e900);
		cotisationRepository.save(e901);
		
		// Insertion des profils de rémunération dans la base
		profilRemunerationRepository.save(profilTechnicien);
		profilRemunerationRepository.save(profilCadre);
		profilRemunerationRepository.save(profilStagiaire);
		
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
		
		
		
		
	}

}
