package br.com.alura.codechella.domain;

import java.time.LocalDate;

public record Usuario(String cpf, String nome, LocalDate nascimento, String email, Endereco endereco) {
  // Construtor compacto para validações
  public Usuario {
    if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
      throw new IllegalArgumentException("CPF no padrão incorreto!");
    }
  }
}
