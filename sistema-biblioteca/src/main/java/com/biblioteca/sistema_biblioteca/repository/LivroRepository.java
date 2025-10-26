package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTitulo(Integer quantidadeDisponivel);
    List<Livro> findByCategoria_NomeIgnoreCase(String nomeCategoria);
    
    @Query("SELECT c.nome, COUNT(l) FROM Livro l JOIN l.categoria c GROUP BY c.nome")
    List<Object[]> contarLivrosPorCategoria();

    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nomeAutor, '%')) ORDER BY l.anoPublicacao")
    List<Livro> findByAutorNome(@Param("nomeAutor") String nomeAutor);

}