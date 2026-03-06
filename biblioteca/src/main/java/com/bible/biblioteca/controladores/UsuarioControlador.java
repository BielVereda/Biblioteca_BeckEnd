package com.bible.biblioteca.controladores;

import com.bible.biblioteca.DTOs.UsuarioDTO;
import com.bible.biblioteca.modelos.Usuario;
import com.bible.biblioteca.servicos.UsuarioServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServico usuarioServico;

    @PostMapping
    public Usuario criar(@RequestBody @Valid UsuarioDTO dto) {
        return usuarioServico.criarUsuario(dto);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioServico.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioServico.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioServico.deletarUsuario(id);
    }

}