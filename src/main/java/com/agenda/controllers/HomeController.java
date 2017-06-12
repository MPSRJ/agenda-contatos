package com.agenda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String inicio(){
		
		return "redirect:/contato";
		
	}
	
	@GetMapping("/404")
	public ModelAndView naoEncotrada(){
		
		return new ModelAndView("/404");
		
	}
	
	@GetMapping("/403")
	public ModelAndView proibida(){
		
		return new ModelAndView("/403");
		
	}
	
	
}
