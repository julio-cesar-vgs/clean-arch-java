package br.com.alura.codechella.domain;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class FabricaUsuario{
  // A fábrica não precisa mais guardar o estado do usuário

  // Este método agora retorna um usuário SEM endereço
  public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
    // Para criar um record, todos os campos devem ser passados.
    // Como o endereço ainda não existe, passamos null.
    return new Usuario(cpf, nome, nascimento, "", null);
  }

  // Este método RECEBE um usuário e retorna um NOVO usuário com o endereço
  public Usuario comEndereco(@NotNull Usuario usuario, String cep, Integer numero, String complemento) {
    Endereco endereco = new Endereco(cep, numero, complemento);
    // Cria uma nova instância de Usuario, copiando os dados do antigo e adicionando o novo endereço
    return new Usuario(usuario.cpf(), usuario.nome(), usuario.nascimento(), usuario.email(), endereco);
  }
}