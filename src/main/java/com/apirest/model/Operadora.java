package com.apirest.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "OPERADORA")
public class Operadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPE_ID", nullable = false)
	private Integer chavePrimaria;

	@Column(name = "OPE_NM", nullable = false)
	private String nome;
	
	@Column(name = "OPE_CATEGORIA", nullable = false)
	private String categoria;
	
	@Column(name = "OPE_PRECO")
	private BigDecimal preco;
	
	@JsonSerialize(using = CalendarSerializer.class)
	@Column(name = "OPE_DH_CADASTRO", nullable = false)
	private Calendar dtCadastro;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operadora")
//	private List<Contato> contatos;
	
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
//	public List<Contato> getContatos() {
//		return contatos;
//	}
//
//	public void setContatos(List<Contato> contatos) {
//		this.contatos = contatos;
//	}

	@Override
	public String toString() {
		return "Key: " + this.chavePrimaria + " Nome: " + this.nome;
	}
}
