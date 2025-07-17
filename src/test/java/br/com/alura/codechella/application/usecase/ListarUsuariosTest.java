package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.RepositorioUsuario;
import br.com.alura.codechella.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ListarUsuariosTest {

    @Mock
    private RepositorioUsuario repositorioUsuario;

    private ListarUsuarios listarUsuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        listarUsuarios = new ListarUsuarios(repositorioUsuario);
    }

    @Test
    void testListaVaziaQuandoNaoHaUsuariosCadastrados() {
        when(repositorioUsuario.listarTodos()).thenReturn(new ArrayList<>());
        List<Usuario> usuarios = listarUsuarios.listarTodos();
        assertEquals(0, usuarios.size());
    }

    @Test
    void testRetorna10UsuariosQuandoHa10UsuariosCadastrados() {
        List<Usuario> usuariosMock = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            usuariosMock.add(new Usuario("Usuario " + i, "usuario" + i,LocalDate.of(2000, 1, 1), "usuario" + i + "@example.com", null));
        }
        when(repositorioUsuario.listarTodos()).thenReturn(usuariosMock);
        List<Usuario> usuarios = listarUsuarios.listarTodos();
        assertEquals(10, usuarios.size());
    }
}