package br.com.nava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.entities.UsuarioEntity;
import br.com.nava.services.UsuarioService;

@RestController
@RequestMapping ("usuarios")
public class UsuarioController {


	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public List<UsuarioEntity> getUsuarios() {		
		return usuarioService.getAll();
	}
	
	@GetMapping("{id}")	
	public UsuarioEntity getOne(@PathVariable Integer id) {
		return usuarioService.getOne(id);
	}
	
	@PostMapping("")
	public UsuarioEntity save(@RequestBody UsuarioEntity usuario) {		
		return usuarioService.save(usuario);
	}
	
	@PatchMapping("{id}")
	public UsuarioEntity update(@PathVariable Integer id, @RequestBody UsuarioEntity usuario) {
		return usuarioService.update(id, usuario);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {		
		usuarioService.delete(id);
	}
}
	
