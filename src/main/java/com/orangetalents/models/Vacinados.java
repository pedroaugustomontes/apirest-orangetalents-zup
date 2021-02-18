package com.orangetalents.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_VACINADOS")
public class Vacinados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String nomeVacina;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private Date dataVacina;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuarios_id")
	@NotNull(message = "Este campo não pode ser nulo")
	private Usuarios usuarios;

	public Vacinados() {
		super();
	}

	public Vacinados(long id, @NotBlank String nomeVacina, @NotNull Date dataVacina, Usuarios usuarios) {
		super();
		this.id = id;
		this.nomeVacina = nomeVacina;
		this.dataVacina = dataVacina;
		this.usuarios = usuarios;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public Date getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
}