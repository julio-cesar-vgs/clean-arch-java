package br.com.alura.codechella.application.gateway;


import br.com.alura.codechella.domain.Usuario;

import java.util.List;

public interface RepositorioUsuario{
  Usuario cadastrarUsuario(Usuario usuario);

  List<Usuario> listarTodos();
}
