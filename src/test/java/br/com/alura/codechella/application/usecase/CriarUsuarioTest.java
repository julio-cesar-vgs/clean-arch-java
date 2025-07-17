package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.RepositorioUsuario;
import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CriarUsuarioTest {

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private CriarUsuario criarUsuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateUserWithValidData() {
        Endereco endereco = new Endereco("123", 10, "Complemento");
        Usuario usuario = new Usuario("123.456.789-00", "Fulano de Tal", LocalDate.of(2000, 1, 1), "email@example.com", endereco);

        when(repositorioUsuario.cadastrarUsuario(usuario)).thenReturn(usuario);

        Usuario createdUser = criarUsuario.cadastrarUsuario(usuario);

        assertNotNull(createdUser);
        assertEquals("Fulano de Tal", createdUser.nome());
        verify(repositorioUsuario, times(1)).cadastrarUsuario(usuario);
    }

    @Test
    void shouldThrowExceptionWhenCreatingUserWithInvalidCpf() {
        Endereco endereco = new Endereco("123", 10, "Complemento");
        Usuario usuario = new Usuario("invalid-cpf", "Fulano de Tal", LocalDate.of(2000, 1, 1), "email@example.com", endereco);

        assertThrows(IllegalArgumentException.class, () -> criarUsuario.cadastrarUsuario(usuario));
        verify(repositorioUsuario, never()).cadastrarUsuario(usuario);
    }

    @Test
    void shouldThrowExceptionWhenCreatingUserWithNullName() {
        Endereco endereco = new Endereco("123", 10, "Complemento");
        Usuario usuario = new Usuario("123.456.789-00", null, LocalDate.of(2000, 1, 1), "email@example.com", endereco);

        assertThrows(IllegalArgumentException.class, () -> criarUsuario.cadastrarUsuario(usuario));
        verify(repositorioUsuario, never()).cadastrarUsuario(usuario);
    }

    @Test
    void shouldThrowExceptionWhenCreatingUserWithBirthDateInTheFuture() {
        Endereco endereco = new Endereco("123", 10, "Complemento");
        Usuario usuario = new Usuario("123.456.789-00", "Fulano de Tal", LocalDate.now().plusDays(1), "email@example.com", endereco);

        assertThrows(IllegalArgumentException.class, () -> criarUsuario.cadastrarUsuario(usuario));
        verify(repositorioUsuario, never()).cadastrarUsuario(usuario);
    }
}