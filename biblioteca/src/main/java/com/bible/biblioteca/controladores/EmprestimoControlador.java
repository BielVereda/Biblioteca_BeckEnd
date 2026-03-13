package com.bible.biblioteca.controladores;

import com.bible.biblioteca.modelos.Emprestimo;
import com.bible.biblioteca.servicos.EmprestimoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoControlador {

    private final EmprestimoServico emprestimoServico;

    @PostMapping("/{usuarioId}")
    public Emprestimo registrar(@PathVariable Long usuarioId) {
        return emprestimoServico.registrarEmprestimo(usuarioId);
    }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoServico.listarTodos();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Emprestimo> listarPorUsuario(@PathVariable Long usuarioId) {
        return emprestimoServico.listarPorUsuario(usuarioId);
    }
}
