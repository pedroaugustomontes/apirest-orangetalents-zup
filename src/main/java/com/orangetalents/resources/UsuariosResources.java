package com.orangetalents.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.models.Usuarios;
import com.orangetalents.repository.UsuariosRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosResources {

	@Autowired
	UsuariosRepository usuariosRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuarios> listaUsuarios() {
		return usuariosRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listaUsuarioUnico(@PathVariable(value="id") long id) {
		Usuarios usuario = usuariosRepository.findById(id);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Usuarios salvarUsuario(@Valid @RequestBody Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}
}