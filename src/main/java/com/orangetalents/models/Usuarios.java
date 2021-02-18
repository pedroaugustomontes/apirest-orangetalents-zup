package com.orangetalents.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_USUARIOS")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O campo nome é de preenchimento obrigatório.")
    private String nome;

    @Email
    @Column(unique = true)
    @NotBlank(message = "O campo email é de preenchimento obrigatório.")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo nascimento é de preenchimento obrigatório.")
    private Date nascimento;

    @CPF
    @Column(unique = true)
    @NotBlank(message = "O campo CPF é de preenchimento obrigatório.")
    private String cpf;

    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    private List<Vacinados> vacinados;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}