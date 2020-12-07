package com.sefaz.accounts.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNotFoundException (String mensagem, Throwable throwable) {
		super (mensagem, throwable);
	}
	
	
}
