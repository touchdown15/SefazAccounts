package com.sefaz.accounts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sefaz.accounts.model.Usuario;
import com.sefaz.accounts.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuarios")
	public ResponseEntity<?> listarTodosOsUsuarios (){
		return new ResponseEntity<>(usuarioService.getAllUsuario(), HttpStatus.OK);
		
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> usuarioPorId (@PathVariable (value = "id") Long id){
		return new ResponseEntity<>(usuarioService.getUsuarioById(id), HttpStatus.OK);
		
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> salvarNovoUsuario (@RequestBody @Valid Usuario usuario){
		return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> deletarUsuario (@PathVariable (value = "id") Long id){
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> atualizarUsuario (@PathVariable (value = "id") Long id,
												@RequestBody @Valid Usuario usuario){
		return new ResponseEntity<>(usuarioService.updateUsuario(usuario), HttpStatus.OK) ;
		
	}

}
