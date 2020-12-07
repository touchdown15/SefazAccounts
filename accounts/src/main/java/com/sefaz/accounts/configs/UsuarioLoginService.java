package com.sefaz.accounts.configs;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.sefaz.accounts.model.Usuario;
import com.sefaz.accounts.service.UsuarioService;

@Repository
public class UsuarioLoginService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioLoginRep;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		List<Usuario> todosUsuarios;
		todosUsuarios = usuarioLoginRep.getAllUsuario();
		Usuario usuarioPesquisa = null;
		
		for (int i = 0; i < todosUsuarios.size(); i++) {
			usuarioPesquisa = todosUsuarios.get(i);
			
			if (usuarioPesquisa.getEmail() == email) {
				i = todosUsuarios.size();
			}else {
				usuarioPesquisa = null;
			}
			
		}
		
		if(usuarioPesquisa == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
			
		}
		
		return usuarioPesquisa;
	}

}