package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecase.CriarUsuario;
import br.com.alura.codechella.domain.Usuario;
import br.com.alura.codechella.infra.controller.dto.UsuarioDto;
import br.com.alura.codechella.infra.controller.dto.UsuarioDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
  private final CriarUsuario criarUsuario;
  private final UsuarioDtoMapper mapper;

  public UsuarioController(CriarUsuario criarUsuario, UsuarioDtoMapper mapper) {
    this.criarUsuario = criarUsuario;
    this.mapper = mapper;
  }

  @PostMapping
  public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
    Usuario usuario = mapper.toDomain(dto);
    Usuario usuarioSalvo = criarUsuario.cadastrarUsuario(usuario);
    return mapper.toDto(usuarioSalvo);
  }
}
