package br.com.alura.codechella.infra.gateway;


import br.com.alura.codechella.application.gateway.RepositorioUsuario;
import br.com.alura.codechella.domain.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioUsuarioJpa implements RepositorioUsuario{

  private final UsuarioRepository repository;
  private final UsuarioMapper mapper;

  public RepositorioUsuarioJpa(UsuarioRepository repository, UsuarioMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Usuario cadastrarUsuario(Usuario usuario) {
    var entity = mapper.toEntity(usuario);

    var usuarioSalvo = repository.save(entity);
    return mapper.toDomain(usuarioSalvo);
  }

  @Override
  public List<Usuario> listarTodos() {
    return List.of();
  }
}
