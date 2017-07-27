package com.apirest.dao;

import com.apirest.model.Operadora;

public class OperadoraDAO extends GenericDAO<Operadora> {

	@Override
	protected void validarDados(Operadora obj) {
		System.out.println("validando dados da operadora");
		
	}

}
