package com.apirest.contato;

import java.math.BigDecimal;
import java.util.Calendar;

import org.hibernate.Session;

import com.apirest.dao.ContatoDAO;
import com.apirest.dao.OperadoraDAO;
import com.apirest.hibernate.HibernateSession;
import com.apirest.model.Contato;
import com.apirest.model.Operadora;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Session session = HibernateSession.getSessionFactory().openSession();
    	
    	ContatoDAO contatoDAO = new ContatoDAO();
    	OperadoraDAO operadoraDAO = new OperadoraDAO();
    	
    	Operadora operadora = new Operadora();
    	operadora.setCategoria("MÓVEL");
    	operadora.setNome("VIVO");
    	operadora.setPreco(new BigDecimal("2.00"));
    	operadora.setDtCadastro(Calendar.getInstance());

    	Contato contato = new Contato();
    	contato.setNome("Marluce Pereira");
    	contato.setFone("(81)90909-1122");
    	contato.setDtCadastro(Calendar.getInstance());
    	contato.setOperadora(operadora);
    	
    	
    	session.beginTransaction();
    	
    	operadoraDAO.save(operadora);
    	contatoDAO.save(contato);
    	System.out.println(contato.getChavePrimaria());
    	System.out.println(operadora.getChavePrimaria());
    	
    	System.out.println(contatoDAO.listAll());
    	
    	session.getTransaction().commit();
    }
}
