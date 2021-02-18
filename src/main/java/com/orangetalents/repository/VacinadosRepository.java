package com.orangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalents.models.Vacinados;

public interface VacinadosRepository extends JpaRepository<Vacinados, Long>{

	Vacinados findById(long id);
}
