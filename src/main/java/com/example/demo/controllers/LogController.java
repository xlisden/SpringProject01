package com.example.demo.controllers;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LogController {
	
	private static final org.apache.commons.logging.Log LOG = LogFactory.getLog(LogController.class);
	
	@GetMapping("/Metodo1")
	public String Metodo1() {
		LOG.info("Ingreso al metodo 1");
		return "vista1";
	}
	
	@GetMapping("/Metodo2")
	public String Metodo2() {
		LOG.error("Ingreso al metodo 2");
		return "vista2";
	}

}
