package br.com.alura.codechella.application.usecase;


import br.com.alura.codechella.application.gateway.RepositorioUsuario;
import br.com.alura.codechella.domain.Usuario;
import org.springframework.stereotype.Service;


public class CriarUsuario{

  private final RepositorioUsuario repositorioUsuario;

  public CriarUsuario(RepositorioUsuario repositorioUsuario) {
    this.repositorioUsuario = repositorioUsuario;
  }


  public Usuario cadastrarUsuario(Usuario usuario) {
    return repositorioUsuario.cadastrarUsuario(usuario);
  }

}
