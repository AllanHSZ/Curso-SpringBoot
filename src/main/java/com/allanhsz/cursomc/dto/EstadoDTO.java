package com.allanhsz.cursomc.dto;

import java.io.Serializable;

import com.allanhsz.cursomc.domain.Estado;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	
	public EstadoDTO() {}
	
	public EstadoDTO(Estado obj) {
		id = obj.getId();
		nome =  obj.getNome();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
