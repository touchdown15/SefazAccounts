package com.sefaz.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table (name = "TB_TELEFONE")
public class Telefone {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column (name = "ddd")
	private int ddd;
	
	@Column (name = "numero")
	private long numero;
	
	@Column (name = "tipo")
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name ="usuario_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Usuario usuario;
	
	public Telefone() {
		
	}
	
	public Telefone(int ddd, long numero, String tipo, Usuario usuario) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

	public int getDdd() {
		return ddd;
	}
	
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	public long getNumero() {
		return numero;
	}
	
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
