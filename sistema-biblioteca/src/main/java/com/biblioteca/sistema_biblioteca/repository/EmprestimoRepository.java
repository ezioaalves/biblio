package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.model.Emprestimo;
import com.biblioteca.sistema_biblioteca.model.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("SELECT e FROM Emprestimo e JOIN FETCH e.itens i JOIN FETCH i.livro l " +
           "WHERE e.usuario.id = :usuarioId AND e.status = :status")
    List<Emprestimo> findAtivosByUsuario(Long usuarioId, StatusEmprestimo status);

    @Query("SELECT e FROM Emprestimo e JOIN FETCH e.usuario u JOIN FETCH e.itens i JOIN FETCH i.livro l " +
           "WHERE e.dataDevolucaoPrevista < :hoje AND e.status = :status")
    List<Emprestimo> findAtrasados(LocalDate hoje, StatusEmprestimo status);
}
