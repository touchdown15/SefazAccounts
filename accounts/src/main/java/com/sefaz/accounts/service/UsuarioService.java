package com.sefaz.accounts.service;

import java.util.List;


import com.sefaz.accounts.model.Usuario;

public interface UsuarioService {
	
	Usuario createUsuario (Usuario usuario);
	Usuario updateUsuario (Usuario usuario);
	List <Usuario> getAllUsuario();
	Usuario getUsuarioById(Long usuarioId);
	public void deleteUsuario(Long usuarioId);
	

}
