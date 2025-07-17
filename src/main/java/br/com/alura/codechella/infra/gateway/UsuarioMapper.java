package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.domain.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import org.jetbrains.annotations.NotNull;

public class UsuarioMapper{
  public UsuarioEntity toEntity(@NotNull Usuario usuario) {
    UsuarioEntity entity = new UsuarioEntity();
    entity.setCpf(usuario.cpf());
    entity.setNome(usuario.nome());
    entity.setNascimento(usuario.nascimento());
    entity.setEmail(usuario.email());
    return entity;
  }


  public Usuario toDomain(@NotNull UsuarioEntity entity) {
    return new Usuario(entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail(), null);
  }

}
