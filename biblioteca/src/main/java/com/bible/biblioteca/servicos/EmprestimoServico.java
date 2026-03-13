package com.bible.biblioteca.servicos;

import com.bible.biblioteca.modelos.Emprestimo;
import com.bible.biblioteca.modelos.Usuario;
import com.bible.biblioteca.repositorios.EmprestimoRepositorio;
import com.bible.biblioteca.repositorios.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoServico {

    private final EmprestimoRepositorio emprestimoRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public Emprestimo registrarEmprestimo(Long usuarioId) {
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(14)); // prazo de 14 dias

        return emprestimoRepositorio.save(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepositorio.findAll();
    }

    public List<Emprestimo> listarPorUsuario(Long usuarioId) {
        return emprestimoRepositorio.findByUsuarioId(usuarioId);
    }
}