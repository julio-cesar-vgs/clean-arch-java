package br.com.alura.codechella.infra.persistence;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity{
    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String cpf, String nome, LocalDate nascimento, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
