package com.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.model.Contato;
import com.agenda.repository.Contatos;



@Service
public class ContatosService {
	
	@Autowired
	private Contatos contatos;
	
	
	public void salvar(Contato contato){
		
		contatos.save(contato);
	}


	public void excluir(Contato contato) {
		
		contatos.delete(contato);
		
	}

}
