package br.com.alura.codechella.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioEntityTest{
  @Test
  public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
    // O construtor do record Usuario agora exige 5 parâmetros, incluindo o Endereco.
    // Para testar a validação do CPF, podemos passar null para o endereço.
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Usuario("12345678999", "Jacque", LocalDate.parse("1990-09-08"),
                                              "email@email.com", null));

  }

  @Test
  public void deveCriarUsuarioUsandoFabricaDeUsuario(){
    FabricaUsuario fabrica = new FabricaUsuario();
    LocalDate dataNascimento = LocalDate.parse("2000-10-01");
    Usuario usuario = fabrica.comNomeCpfNascimento("Emily", "654.123.897-88", dataNascimento);

    // Em records, os métodos de acesso não têm o prefixo "get"
    Assertions.assertEquals("Emily", usuario.nome());
    Assertions.assertEquals("654.123.897-88", usuario.cpf());
    Assertions.assertEquals(dataNascimento, usuario.nascimento());
  }

  @Test
  public void deveCriarUsuarioCompletoAdicionandoEndereco() {
    FabricaUsuario fabrica = new FabricaUsuario();
    Usuario usuarioBase = fabrica.comNomeCpfNascimento("Emily", "654.123.897-88", LocalDate.parse("2000-10-01"));
    Usuario usuarioCompleto = fabrica.comEndereco(usuarioBase, "01001-000", 123, "apto 42");

    Assertions.assertNotNull(usuarioCompleto.endereco());
    Assertions.assertEquals("01001-000", usuarioCompleto.endereco().cep());
    Assertions.assertEquals(123, usuarioCompleto.endereco().numero());
  }
}