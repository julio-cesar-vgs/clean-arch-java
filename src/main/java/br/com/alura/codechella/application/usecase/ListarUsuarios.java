package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.RepositorioUsuario;
import br.com.alura.codechella.domain.Usuario;

import java.util.List;

public class ListarUsuarios{
  private final RepositorioUsuario repository;

  public ListarUsuarios(RepositorioUsuario repository) {
    this.repository = repository;
  }

  List<Usuario> listarTodos() {
    return repository.listarTodos();
  }
}
