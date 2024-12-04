package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.components.PrimerComponente;
import com.example.demo.model.Persona;

@Controller
@RequestMapping("/PostController")
public class PostController {
	
	@Autowired
	@Qualifier("primerComponent")
	private PrimerComponente primerComponente;
	
//	@GetMapping({"/", ""})
//	public String redirect() {
//		return "redirect:/PostController/form";
//	}	
	
	@GetMapping({"/", ""})
	public RedirectView redirect() {
		return new RedirectView("/PostController/form");
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping("/addpersona")
//	public ModelAndView addPersona(@ModelAttribute("persona") Persona persona) {
	public ModelAndView addPersona(@ModelAttribute() Persona persona) {
		ModelAndView mav = new ModelAndView("resultado");
		mav.addObject("persona", persona);
		return mav;
	}
	
}
