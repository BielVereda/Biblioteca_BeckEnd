package com.bible.biblioteca.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "carteiras")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarteiraBiblioteca {

    @Id
    private Long numeroCarteira;
    private LocalDate dataEmissao;
    private Boolean valida;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}