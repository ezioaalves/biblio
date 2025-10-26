package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.Emprestimo;
import com.biblioteca.sistema_biblioteca.model.StatusEmprestimo;
import com.biblioteca.sistema_biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {
    
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> listarAtivosPorUsuario(Long usuarioId) {
        return emprestimoRepository.findAtivosByUsuario(usuarioId, StatusEmprestimo.ATIVO);
    }

    public List<Emprestimo> listarAtrasados() {
        return emprestimoRepository.findAtrasados(LocalDate.now(), StatusEmprestimo.ATIVO);
    }
}
