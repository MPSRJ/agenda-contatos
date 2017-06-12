package com.agenda.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.exceptions.ImpossivelExcluirEntidadeException;
import com.agenda.model.Contato;
import com.agenda.repository.Contatos;
import com.agenda.service.ContatosService;


@Controller
@RequestMapping("/contato")
public class AgendaController {
	
	@Autowired
	private Contatos contatos;
	
	@Autowired
	private ContatosService contatosService;
	
	@GetMapping
	public ModelAndView iniciar(Contato contato){
		
		ModelAndView mv = new ModelAndView("home-page");
		
		mv.addObject("contatos", contatos.findAll());
		
		return mv;
	}
	
	@PostMapping(value={"/novo", "{\\d+}"})
	public ModelAndView   salvar( @Valid Contato contato, BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			
			return iniciar(contato);
		}
		
		contatosService.salvar(contato);
		
		attributes.addFlashAttribute("mensagem", "Contato salvo com sucesso!");
	
		return new ModelAndView("redirect:/");
		
	}
	
	
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Contato contato){
		
		ModelAndView mv = iniciar(contato);
		
		mv.addObject(contato);
		
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Contato contato) {
		try {
			contatosService.excluir(contato);
		} catch (ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}

}
