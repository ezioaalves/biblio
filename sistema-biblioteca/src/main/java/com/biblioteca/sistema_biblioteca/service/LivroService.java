package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.Livro;
import com.biblioteca.sistema_biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livroRepository.findByQuantidadeDisponivelGreaterThanOrderByTitulo(0);
    }

    public List<Livro> listarPorCategoria(String nomeCategoria) {
        return livroRepository.findByCategoria_NomeIgnoreCase(nomeCategoria);
    }

    public List<Object[]> contarLivrosPorCategoria() {
        return livroRepository.contarLivrosPorCategoria();
    }

    public List<Livro> listarPorAutor(String nomeAutor) {
        return livroRepository.findByAutorNome(nomeAutor);
    }
}
