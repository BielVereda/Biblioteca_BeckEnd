package com.bible.biblioteca.servicos;

import com.bible.biblioteca.DTOs.UsuarioDTO;
import com.bible.biblioteca.modelos.Usuario;
import com.bible.biblioteca.repositorios.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;

    public Usuario criarUsuario(UsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        return usuarioRepositorio.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepositorio.findById(id).orElseThrow();
    }

    public void deletarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }

}