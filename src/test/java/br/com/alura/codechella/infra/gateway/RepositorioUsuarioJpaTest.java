package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.domain.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RepositorioUsuarioJpaTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private RepositorioUsuarioJpa repositorioUsuarioJpa;

    @BeforeEach
    void setUp() {
        repositorioUsuarioJpa = new RepositorioUsuarioJpa(usuarioRepository, new UsuarioMapper());
    }

    @Test
    void shouldSaveUserSuccessfully() {
        // Arrange
        Endereco endereco = new Endereco("123", "Rua Teste", "Cidade Teste", "Estado Teste");
        Usuario usuario = new Usuario("123.456.789-00", "João Silva", LocalDate.of(1990, 5, 15), "joao.silva@example.com", endereco);

        // Act
        repositorioUsuarioJpa.cadastrar(usuario);

        // Assert
        UsuarioEntity savedUserEntity = usuarioRepository.findByCpf("123.456.789-00");
        assertThat(savedUserEntity).isNotNull();
        assertThat(savedUserEntity.getCpf()).isEqualTo("123.456.789-00");
        assertThat(savedUserEntity.getNome()).isEqualTo("João Silva");
        assertThat(savedUserEntity.getEmail()).isEqualTo("joao.silva@example.com");
    }

    @Test
    void shouldFindUserByCpf() {
        // Arrange
        UsuarioEntity userEntity = new UsuarioEntity();
        userEntity.setCpf("987.654.321-99");
        userEntity.setNome("Maria Oliveira");
        userEntity.setNascimento(LocalDate.of(1985, 10, 20));
        userEntity.setEmail("maria.oliveira@example.com");
        usuarioRepository.save(userEntity);

        // Act
        Usuario foundUsuario = repositorioUsuarioJpa.buscarPorCpf("987.654.321-99");

        // Assert
        assertThat(foundUsuario).isNotNull();
        assertThat(foundUsuario.getCpf()).isEqualTo("987.654.321-99");
        assertThat(foundUsuario.getNome()).isEqualTo("Maria Oliveira");
        assertThat(foundUsuario.getEmail()).isEqualTo("maria.oliveira@example.com");
    }

    @Test
    void shouldReturnNullWhenUserNotFoundByCpf() {
        // Act
        Usuario foundUsuario = repositorioUsuarioJpa.buscarPorCpf("000.000.000-00");

        // Assert
        assertThat(foundUsuario).isNull();
    }

    // You can add more tests for listing users, updating, deleting, etc.
}