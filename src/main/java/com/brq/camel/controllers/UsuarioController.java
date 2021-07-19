package com.brq.camel.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.camel.models.UsuarioModel;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

	private ArrayList<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();

	// construtor
	public UsuarioController() {
		this.adicionarUsuarios();
	}

	private void adicionarUsuarios() {
		UsuarioModel usuario = new UsuarioModel();
		for (int i = 0; i <= 5; i++) {
			usuario = new UsuarioModel( "Isadora Palhoti " + i, "isadora" + i + "@gmail.com");
			this.usuarios.add(usuario);
		}
	}

	// getAll
	@GetMapping(value = "")
	public ArrayList<UsuarioModel> getAll() {
		return this.usuarios;
	}

	// getOne
	@GetMapping(value = "{id}")
	public UsuarioModel getOne(@PathVariable("id") int id) throws Exception {
		try {
			return this.usuarios.get(id);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Índice não encontrado");
		} catch (Exception e) {
			throw new Exception("Erro no servidor");
		}
	}

	// delete
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable("id") int id) throws Exception {
		try {
			this.usuarios.remove(id);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Índice não encontrado");
		} catch (Exception e) {
			throw new Exception("Erro no servidor");
		}
	}

	// post
	@PostMapping(value = "")
	public UsuarioModel save(@RequestBody UsuarioModel usuario) {
		this.usuarios.add(usuario);
		return usuario;
	}

	// update
	@PatchMapping(value = "{id}")
	public UsuarioModel update(@RequestBody UsuarioModel usuario, @PathVariable("id") int id) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if (id == this.usuarios.get(i).getId()) {
				this.usuarios.get(i).setEmail( usuario .getEmail() );
				this.usuarios.get(i).setName( usuario .getName() );
			}
		}
		return usuario;
	}
}
