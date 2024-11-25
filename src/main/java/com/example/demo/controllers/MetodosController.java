package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/MetodosController") //el nombre de la ruta del controlador (en este caso, la ruta raiz, porque cada metodo puede tener su ruta)
public class MetodosController {

	@GetMapping(value = "/MetodoUno") //no necesariamente debe ser el mismo nombre
	public String Metodo1() {
		return "vista1";
	}
	
	@GetMapping("/Metodo2")
	public ModelAndView Metodo2() {
		return new ModelAndView("vista2");
	}
}