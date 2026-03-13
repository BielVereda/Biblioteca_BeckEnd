package com.bible.biblioteca.repositorios;

import com.bible.biblioteca.modelos.CarteiraBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraBibliotecaRepositorio extends JpaRepository<CarteiraBiblioteca, Long> {
}