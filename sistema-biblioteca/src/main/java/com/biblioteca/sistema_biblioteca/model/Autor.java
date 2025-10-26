package com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;

    @Column(length = 2000)
    private String biografia;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
}
