package com.orangetalents.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.models.Usuarios;
import com.orangetalents.repository.UsuariosRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosResources {

	@Autowired
	UsuariosRepository usuariosRepository;

	@GetMapping
	public List<Usuarios> listaUsuarios() {
		return usuariosRepository.findAll();
	}

	@GetMapping("/{id}")
	public Usuarios listaUsuarioUnico(@PathVariable(value="id") long id) {
		return usuariosRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Usuarios salvarUsuario(@RequestBody Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}
}