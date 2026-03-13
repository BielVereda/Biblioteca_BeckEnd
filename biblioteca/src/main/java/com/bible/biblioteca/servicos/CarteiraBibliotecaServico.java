package com.bible.biblioteca.servicos;

import com.bible.biblioteca.modelos.CarteiraBiblioteca;
import com.bible.biblioteca.modelos.Usuario;
import com.bible.biblioteca.repositorios.CarteiraBibliotecaRepositorio;
import com.bible.biblioteca.repositorios.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CarteiraBibliotecaServico {

    private final CarteiraBibliotecaRepositorio carteiraRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public CarteiraBiblioteca emitirCarteira(Long usuarioId) {
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        CarteiraBiblioteca carteira = new CarteiraBiblioteca();
        carteira.setNumeroCarteira(System.currentTimeMillis());
        carteira.setDataEmissao(LocalDate.now());
        carteira.setValida(true);
        carteira.setUsuario(usuario);

        return carteiraRepositorio.save(carteira);
    }
}