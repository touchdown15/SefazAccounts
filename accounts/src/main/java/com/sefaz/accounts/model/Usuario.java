package com.sefaz.accounts.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table (name = "TB_USUARIO")
public class Usuario implements UserDetails{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column (name = "nome")
	private String nome;
	
	@NotBlank
	@Column (name = "email")
	private String email;
	
	@NotBlank
	@Column (name = "senha")
	private String senha;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
	private List <Telefone> lista_de_telefone = new ArrayList <>();

	public Usuario() {
		
	}

	public Usuario(@NotBlank String nome, @NotBlank String email, @NotBlank String senha,
			List<Telefone> lista_de_telefone) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.lista_de_telefone = lista_de_telefone;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Telefone> getLista_de_telefone() {
		return lista_de_telefone;
	}


	public void setLista_de_telefone(List<Telefone> lista_de_telefone) {
		this.lista_de_telefone = lista_de_telefone;
		
		for(Telefone t : lista_de_telefone) {
			t.setUsuario(this);
		}
	}
	
	public void limparListaDeTelefone(){
		this.lista_de_telefone.clear();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
