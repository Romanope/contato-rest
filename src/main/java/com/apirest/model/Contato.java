package com.apirest.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apirest.util.CalendarSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "CONTATO")
public class Contato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CON_ID")
	private Integer chavePrimaria;
	
	@Column(name = "CON_NM")
	private String nome;
	
	@Column(name = "CON_FONE")
	private String fone;
	
	@Column(name = "CON_DH_CADASTRO")
	@JsonSerialize(using = CalendarSerializer.class)
	private Calendar dtCadastro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OPE_ID", nullable = false)
	private Operadora operadora;
	
	public Integer getChavePrimaria() {
		return chavePrimaria;
	}

	public void setChavePrimaria(Integer chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}
}
