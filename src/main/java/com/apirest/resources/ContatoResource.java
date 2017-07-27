package com.apirest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apirest.dao.ContatoDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Path("/contato")
public class ContatoResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String get() {
		ContatoDAO contatoDAO = new ContatoDAO();
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(contatoDAO.listAll());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		} finally {
			System.out.println("finalizando consulta dos contatos");
		}
	}
}
