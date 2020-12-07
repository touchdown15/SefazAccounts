package com.sefaz.accounts.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sefaz.accounts.model.Usuario;
import com.sefaz.accounts.service.UsuarioService;

@Controller
public class UsuarioControllerParaJSP {

	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioControllerParaJSP(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
    public String listarTodosOsUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        return "usuarios";
    }

    @GetMapping("/novo-usuario")
    public String mostrarFormsDoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "novo-usuario";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String adicionarNovoUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novo-usuario";
        }
        usuarioService.createUsuario(usuario);
        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        return "usuarios";
    }

    @GetMapping("/{id}")
    public String mostrarUsuarioPorId(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "edit-usuario";
    }

    @PostMapping("/{id}/update")
    public String atualizarUsuario(@PathVariable Long id, @Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-usuario";
        }
        usuarioService.getUsuarioById(id);
        usuarioService.updateUsuario(usuario);
        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        return "usuarios";
    }

    @PostMapping("/{id}/delete")
    public String deletarUsuario(@PathVariable Long id, Model model) {
        usuarioService.getUsuarioById(id);
        usuarioService.deleteUsuario(id);
        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        return "usuarios";
    }
	
}
