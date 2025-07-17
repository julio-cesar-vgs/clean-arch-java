package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateway.RepositorioUsuario;
import br.com.alura.codechella.application.usecase.CriarUsuario;
import br.com.alura.codechella.infra.controller.dto.UsuarioDtoMapper;
import br.com.alura.codechella.infra.gateway.RepositorioUsuarioJpa;
import br.com.alura.codechella.infra.gateway.UsuarioMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

  @Bean
  CriarUsuario criarUsuario(RepositorioUsuario repositorioDeUsuario){
    return new CriarUsuario(repositorioDeUsuario);
  }

  @Bean
  RepositorioUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioMapper mapper){
    return new RepositorioUsuarioJpa(repositorio, mapper);
  }

  @Bean
  UsuarioMapper retornaMapper(){
    return new UsuarioMapper();
  }


}