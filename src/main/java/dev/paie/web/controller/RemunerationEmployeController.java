package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.util.PaieUtils;

/**
 * Controlleur pour l'entite RemunerationEmploye
 * 
 * @author Sandra Le Thiec
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired private EntrepriseRepository entrepriseRepository;
	@Autowired private ProfilRemunerationRepository profilRepository;
	@Autowired private GradeRepository gradeRepository;
	@Autowired private RemunerationEmployeRepository employeRepository;
	@Autowired private PaieUtils paieUtils;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView showForm(Model model) {
		RemunerationEmploye employe  = new RemunerationEmploye();
		model.addAttribute("employe",employe);
		ModelAndView mv = new ModelAndView();
		// Liste des entreprises
		List<Entreprise> listeEntreprises = entrepriseRepository.findAll();
		// Liste des profils
		List<ProfilRemuneration> listeProfil = profilRepository.findAll();
		// Liste des grades
		List<Grade> listeGrade = gradeRepository.findAll();
		
		// Liste des employés
		List<RemunerationEmploye> listeEmploye = employeRepository.findAll();
		
		List<JSONObject> gradeObject = new ArrayList<>();
		listeGrade.stream().forEach(g -> {
			String[] codeSplit = g.getCode().split("_");
			String code = codeSplit[0].toLowerCase();
			BigDecimal salarieBrutBase = g.getNbHeuresBase().multiply(g.getTauxBase());
			code = paieUtils.upperCaseFirst(code);
			code += " " + codeSplit[1] + " - " + paieUtils.formaterBigDecimal(salarieBrutBase) + " € / an";
			JSONObject json = new JSONObject();
			json.put("id", g.getId());
			json.put("label", code);
			gradeObject.add(json);	
		});
		
		String matricule = "M01";
		if(listeEmploye.size() > 0) {
			String dernierMatricule = listeEmploye.get(listeEmploye.size()-1).getMatricule();
			String[] numMatriculeSpilt = dernierMatricule.split("M0");
			int numMatricule = Integer.valueOf(numMatriculeSpilt[1]) + 1;
			matricule = "M0"+numMatricule;
		}
		
		
		mv.setViewName("employes/creerEmploye");
		mv.addObject("matricule", matricule);
		mv.addObject("listeEntreprises", listeEntreprises);
		mv.addObject("listeProfils", listeProfil);
		mv.addObject("gradeObject", gradeObject);		
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@RequestParam("entreprise") Integer idEntreprise,
			@RequestParam("profilRemuneration") Integer idProfil,
			@RequestParam("grade") Integer idGrade,
			@ModelAttribute("employe") RemunerationEmploye employe,BindingResult result) {

		employe.setDateCreation(LocalDateTime.now());
		employe.setEntreprise(entrepriseRepository.findOne(idEntreprise));
		employe.setProfilRemuneration(profilRepository.findOne(idProfil));
		employe.setGrade(gradeRepository.findOne(idGrade));
		employeRepository.save(employe);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		return new ModelAndView("redirect:/mvc/employes/lister");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView showEmployes() {
		ModelAndView mv = new ModelAndView();
		List<RemunerationEmploye> listEmployes = employeRepository.findAll();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("listEmployes",listEmployes);
		return mv;
	}

}
