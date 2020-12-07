package com.sefaz.accounts.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefaz.accounts.exception.UsuarioNotFoundException;
import com.sefaz.accounts.model.Telefone;
import com.sefaz.accounts.model.Usuario;
import com.sefaz.accounts.repository.TelefoneRepository;
import com.sefaz.accounts.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		
		Usuario usuarioUpdate = usuario;
		
		usuarioRepository.save(usuarioUpdate);
		
		return usuarioUpdate;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		
		Optional <Usuario> usuarioDoBanco = this.usuarioRepository.findById(usuario.getId());
		
		if(usuarioDoBanco.isPresent()) {
			
			List <Telefone> telefonesParaDeletar;
			Usuario usuarioUpdate = usuarioDoBanco.get();
			
			telefonesParaDeletar = usuarioUpdate.getLista_de_telefone();
			for(int i = 0; i < telefonesParaDeletar.size(); i++) {
				Telefone telefone10 = telefonesParaDeletar.get(i);
				this.telefoneRepository.delete(telefone10);
			}
			
			
			
			
			usuarioUpdate.setId(usuario.getId());
			usuarioUpdate.setNome(usuario.getNome());
			usuarioUpdate.setEmail(usuario.getEmail());
			usuarioUpdate.setSenha(usuario.getSenha());
			usuarioUpdate.setLista_de_telefone(usuario.getLista_de_telefone());
			usuarioRepository.save(usuarioUpdate);
			return usuarioUpdate;
			
		}else {
			throw new UsuarioNotFoundException ("Usuario não encontrado");
			
		}
	
	}

	@Override
	public List<Usuario> getAllUsuario() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long usuarioId) {
		
		Optional <Usuario> usuarioDoBanco = this.usuarioRepository.findById(usuarioId);
		
		if(usuarioDoBanco.isPresent()) {
			return usuarioDoBanco.get();
			
		}else {
			throw new UsuarioNotFoundException ("Usuario não encontrado");
			
		}
	}

	@Override
	public void deleteUsuario(Long usuarioId) {
		Optional <Usuario> usuarioDoBanco = this.usuarioRepository.findById(usuarioId);
		
		if(usuarioDoBanco.isPresent()) {
			this.usuarioRepository.delete(usuarioDoBanco.get());
			
		}else {
			throw new UsuarioNotFoundException ("Usuario não encontrado");
			
		}
		
	}

	
	
}
