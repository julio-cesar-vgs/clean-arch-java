package br.com.alura.codechella.infra.controller.dto;

import br.com.alura.codechella.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoMapper {

    public Usuario toDomain(UsuarioDto dto) {
        return new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email(), null);
    }

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.cpf(), usuario.nome(), usuario.nascimento(), usuario.email());
    }

}