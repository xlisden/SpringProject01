package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Persona;

@Controller
@RequestMapping("/MetodosController") //el nombre de la ruta del controlador (en este caso, la ruta raiz, porque cada metodo puede tener su ruta)
public class MetodosController {

	@GetMapping(value = "/MetodoUno") //no necesariamente debe ser el mismo nombre
	public String Metodo1() {
		return "vista1";
	}
	
	@GetMapping("/Metodo2")
	public ModelAndView Metodo2() { //se puede agregar o referenciar un objeto
		ModelAndView mav = new ModelAndView("vista2"); //esta direccionando a la vista
		mav.addObject("personas", getPersonas());
		return mav;
	}
	
	private List<Persona> getPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Java Spring", "987654321"));
		personas.add(new Persona("Java C++", "956874412"));
		personas.add(new Persona("Python", "987654321"));
		personas.add(new Persona("Spring Boot", "963258741"));
		personas.add(new Persona("Java JPA", "931478562"));
		personas.add(new Persona("Typescript", "987654123"));
		personas.add(new Persona("CSharp", "951236874"));
		return personas;
	}
	
	@GetMapping("/Metodo3")
	public ModelAndView Metodo3(@RequestParam(name = "nombre") String nombre) { //el parametro sera del nombre @RequestParam(name = "nombre")
		ModelAndView mav = new ModelAndView("vista3"); 
		mav.addObject("nombre", nombre);
		return mav; 
	}
	
	@GetMapping("/Metodo4/{nombre}")
//	public ModelAndView metodo4(@PathVariable(name="nombre") String nombre) {
	public ModelAndView metodo4(@PathVariable() String nombre) {
		ModelAndView mav = new ModelAndView("vista4");
		mav.addObject("nombre", nombre);
		return mav; 
	}
	
}
