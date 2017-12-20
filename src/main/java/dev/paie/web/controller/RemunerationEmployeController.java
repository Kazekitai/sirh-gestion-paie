package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlleur pour l'entite RemunerationEmploye
 * 
 * @author Sandra Le Thiec
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("prefixMatricule", "M00");
		return mv;
	}

}
