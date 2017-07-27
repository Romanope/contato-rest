package com.apirest.dao;

import com.apirest.model.Contato;

public class ContatoDAO extends GenericDAO<Contato> {
	
	public ContatoDAO() {
	
	}
	
	@Override
	protected void validarDados(Contato obj) {
		System.out.println("Validando dados do objeto");
		System.out.println("nome do registro: " + obj.getNome());
	}
}
