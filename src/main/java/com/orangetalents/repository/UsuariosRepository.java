package com.orangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalents.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

	Usuarios findById(long id);
}
