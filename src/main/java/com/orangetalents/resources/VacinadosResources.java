package com.orangetalents.resources;

import java.util.List;

import javax.validation.Valid;

import com.orangetalents.models.Usuarios;
import com.orangetalents.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.models.Vacinados;
import com.orangetalents.repository.VacinadosRepository;

@RestController
@RequestMapping(value = "/vacinados")
public class VacinadosResources {

	@Autowired
	VacinadosRepository vacinadosRepository;

	@Autowired
	UsuariosRepository usuariosRepository;

	@GetMapping
	public List<Vacinados> listaVacinados() {
		return vacinadosRepository.findAll();
	}

	@GetMapping("/{id}")
	public Vacinados listaVacinadosUnico(@PathVariable(value="id") long id) {
		return vacinadosRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Vacinados salvarVacinado(@Valid @RequestBody Vacinados vacinados) {
		Usuarios usuarios = usuariosRepository.findById(vacinados.getUsuarios().getId());
		vacinados.setUsuarios(usuarios);
		return vacinadosRepository.save(vacinados);
	}
}