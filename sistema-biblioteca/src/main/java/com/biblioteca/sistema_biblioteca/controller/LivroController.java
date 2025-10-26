package com.biblioteca.sistema_biblioteca.controller;

import com.biblioteca.sistema_biblioteca.model.Livro;
import com.biblioteca.sistema_biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/disponiveis")
    public List<Livro> listarLivrosDisponiveis() {
        return livroService.listarLivrosDisponiveis();
    }

    @GetMapping("/categoria/{nome}")
    public List<Livro> listarPorCategoria(@PathVariable String nome) {
        return livroService.listarPorCategoria(nome);
    }

    @GetMapping("/estatisticas/por-categoria")
    public List<Object[]> contarLivrosPorCategoria() {
        return livroService.contarLivrosPorCategoria();
    }

    @GetMapping("/autor/{nome}")
    public List<Livro> listarPorAutor(@PathVariable String nome) {
        return livroService.listarPorAutor(nome);
    }
}
