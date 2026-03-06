package com.bible.biblioteca.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Emprestimo> emprestimos;

    @OneToOne(mappedBy = "usuario")
    private CarteiraBiblioteca carteiraBiblioteca;
}