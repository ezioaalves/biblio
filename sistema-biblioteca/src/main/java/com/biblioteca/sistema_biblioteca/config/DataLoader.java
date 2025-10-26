package com.biblioteca.sistema_biblioteca.config;

import com.biblioteca.sistema_biblioteca.model.*;
import com.biblioteca.sistema_biblioteca.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner{
    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;

    public DataLoader(LivroRepository livroRepository, CategoriaRepository categoriaRepository, UsuarioRepository usuarioRepository, EmprestimoRepository emprestimoRepository){
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public void run(String... args){
        Categoria ficcao = new Categoria();
        ficcao.setNome("Ficção Cientifica");
        ficcao.setDescricao("Livros de ficção especulativa científica");
        categoriaRepository.save(ficcao);

        Livro livro1 = new Livro();
        livro1.setTitulo("Duna");
        livro1.setIsbn("9780441172719");
        livro1.setEditora("Chilton Books");
        livro1.setAnoPublicacao(1965);
        livro1.setNumeroPaginas(412);
        livro1.setQuantidadeTotal(10);
        livro1.setQuantidadeDisponivel(7);
        livro1.setCategoria(ficcao);

        Livro livro2 = new Livro();
        livro2.setTitulo("Neuromancer");
        livro2.setIsbn("9780441569595");
        livro2.setEditora("Ace");
        livro2.setAnoPublicacao(1984);
        livro2.setNumeroPaginas(271);
        livro2.setQuantidadeTotal(5);
        livro2.setQuantidadeDisponivel(0); // Not available
        livro2.setCategoria(ficcao);

        livroRepository.save(livro1);
        livroRepository.save(livro2);

        // Add sample users
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João Silva");
        usuario1.setCpf("12345678900");
        usuario1.setEmail("joao.silva@email.com");
        usuario1.setTelefone("11999999999");
        usuario1.setDataCadastro(LocalDate.now());
        usuario1.setEndereco("Rua A, 123");
        usuario1.setAtivo(true);
        usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Maria Silva Santos");
        usuario2.setCpf("98765432100");
        usuario2.setEmail("maria.silva@email.com");
        usuario2.setTelefone("11888888888");
        usuario2.setDataCadastro(LocalDate.now());
        usuario2.setEndereco("Rua B, 456");
        usuario2.setAtivo(true);
        usuarioRepository.save(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Pedro Santos");
        usuario3.setCpf("45678912300");
        usuario3.setEmail("pedro.santos@email.com");
        usuario3.setTelefone("11777777777");
        usuario3.setDataCadastro(LocalDate.now());
        usuario3.setEndereco("Rua C, 789");
        usuario3.setAtivo(true);
        usuarioRepository.save(usuario3);

        // Add sample loans
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setUsuario(usuario1);
        emprestimo1.setDataEmprestimo(LocalDate.now().minusDays(10));
        emprestimo1.setDataDevolucaoPrevista(LocalDate.now().plusDays(10));
        emprestimo1.setStatus(StatusEmprestimo.ATIVO);
        emprestimo1.setValorMulta(0.0);
        
        ItemEmprestimo item1 = new ItemEmprestimo();
        item1.setEmprestimo(emprestimo1);
        item1.setLivro(livro1);
        
        List<ItemEmprestimo> itens1 = new ArrayList<>();
        itens1.add(item1);
        emprestimo1.setItens(itens1);
        emprestimoRepository.save(emprestimo1);

        Emprestimo emprestimo2 = new Emprestimo();
        emprestimo2.setUsuario(usuario2);
        emprestimo2.setDataEmprestimo(LocalDate.now().minusDays(15));
        emprestimo2.setDataDevolucaoPrevista(LocalDate.now().minusDays(5)); // Overdue
        emprestimo2.setStatus(StatusEmprestimo.ATIVO);
        emprestimo2.setValorMulta(25.0);
        
        ItemEmprestimo item2 = new ItemEmprestimo();
        item2.setEmprestimo(emprestimo2);
        item2.setLivro(livro2);
        
        List<ItemEmprestimo> itens2 = new ArrayList<>();
        itens2.add(item2);
        emprestimo2.setItens(itens2);
        emprestimoRepository.save(emprestimo2);

        Emprestimo emprestimo3 = new Emprestimo();
        emprestimo3.setUsuario(usuario1);
        emprestimo3.setDataEmprestimo(LocalDate.now().minusDays(3));
        emprestimo3.setDataDevolucaoPrevista(LocalDate.now().plusDays(7));
        emprestimo3.setStatus(StatusEmprestimo.ATIVO);
        emprestimo3.setValorMulta(0.0);
        
        ItemEmprestimo item3 = new ItemEmprestimo();
        item3.setEmprestimo(emprestimo3);
        item3.setLivro(livro1);
        
        List<ItemEmprestimo> itens3 = new ArrayList<>();
        itens3.add(item3);
        emprestimo3.setItens(itens3);
        emprestimoRepository.save(emprestimo3);
    }
    
}
