package com.sefaz.accounts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sefaz.accounts.exception.UsuarioNotFoundException;
import com.sefaz.accounts.model.Telefone;
import com.sefaz.accounts.model.Usuario;
import com.sefaz.accounts.repository.TelefoneRepository;
import com.sefaz.accounts.repository.UsuarioRepository;

public class TelefoneServiceImpl implements TelefoneService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	
	@Override
	public Telefone createTelefone(Telefone telefone) {
		Optional <Usuario> usuarioDoBanco = this.usuarioRepository.findById(telefone.getUsuario().getId());
		if(usuarioDoBanco.isPresent()) {
			telefone.setUsuario(usuarioDoBanco.get());
			Telefone telefoneSalvo = telefoneRepository.save(telefone);
			return telefoneSalvo;
			
		}else {
			throw new UsuarioNotFoundException ("Telefone não encontrado");
		}
		
	}

	@Override
	public Telefone updateTelefone(Telefone telefone) {
		Optional <Usuario> usuarioDoBanco = this.usuarioRepository.findById(telefone.getUsuario().getId());
		Optional <Telefone> telefoneDoBanco = this.telefoneRepository.findById(telefone.getId());
		if(usuarioDoBanco.isPresent() && telefoneDoBanco.isPresent() ) {
			
			Usuario usuarioUpdate = usuarioDoBanco.get();
			Telefone telefoneUpdate = telefoneDoBanco.get();
			
			telefoneUpdate.setUsuario(usuarioUpdate);
			telefoneUpdate.setId(telefone.getId());
			telefoneUpdate.setDdd(telefone.getDdd());
			telefoneUpdate.setNumero(telefone.getNumero());
			telefoneUpdate.setTipo(telefone.getTipo());
			
			telefoneRepository.save(telefoneUpdate);
			return telefoneUpdate;

		}else {
			throw new UsuarioNotFoundException ("Telefone não encontrado");
		}
		
	}

	@Override
	public List<Telefone> getAllTelefone() {
		return this.telefoneRepository.findAll();
	}

	@Override
	public Telefone getTelefoneById(Long telefoneId) {
		Optional <Telefone> telefoneDoBanco = this.telefoneRepository.findById(telefoneId);
		if(telefoneDoBanco.isPresent()) {
			return telefoneDoBanco.get();
			
		}else {
			throw new UsuarioNotFoundException ("Telefone não encontrado");
			
		}
	}

	@Override
	public void deleteTelefone(Long telefoneId) {
		Optional <Telefone> telefoneDoBanco = this.telefoneRepository.findById(telefoneId);
		
		if(telefoneDoBanco.isPresent()) {
			this.telefoneRepository.delete(telefoneDoBanco.get());
			
		}else {
			throw new UsuarioNotFoundException ("Usuario não encontrado");
			
		}
		
	}
	
	

}
