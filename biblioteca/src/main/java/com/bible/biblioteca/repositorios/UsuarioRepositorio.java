package com.bible.biblioteca.repositorios;

import com.bible.biblioteca.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}