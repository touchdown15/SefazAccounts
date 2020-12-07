package com.sefaz.accounts.service;

import java.util.List;

import com.sefaz.accounts.model.Telefone;

public interface TelefoneService {

	Telefone createTelefone (Telefone telefone);
	Telefone updateTelefone (Telefone telefone);
	List <Telefone> getAllTelefone();
	Telefone getTelefoneById(Long telefoneId);
	public void deleteTelefone(Long usuarioId);
	
}
