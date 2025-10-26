package com.biblioteca.sistema_biblioteca.controller;

import com.biblioteca.sistema_biblioteca.model.Emprestimo;
import com.biblioteca.sistema_biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {
    
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/ativos/{usuarioId}")
    public List<Emprestimo> listarAtivosPorUsuario(@PathVariable Long usuarioId) {
        return emprestimoService.listarAtivosPorUsuario(usuarioId);
    }

    @GetMapping("/atrasados")
    public List<Emprestimo> listarAtrasados() {
        return emprestimoService.listarAtrasados();
    }
}
