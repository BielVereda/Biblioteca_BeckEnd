package com.bible.biblioteca.controladores;

import com.bible.biblioteca.modelos.CarteiraBiblioteca;
import com.bible.biblioteca.servicos.CarteiraBibliotecaServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carteiras")
@RequiredArgsConstructor
public class CarteiraBibliotecaControlador {

    private final CarteiraBibliotecaServico carteiraServico;

    @PostMapping("/emitir/{usuarioId}")
    public CarteiraBiblioteca emitir(@PathVariable Long usuarioId) {
        return carteiraServico.emitirCarteira(usuarioId);
    }
}