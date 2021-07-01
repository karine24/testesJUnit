package br.com.curso.exerciciossb.controllers;

import br.com.curso.exerciciossb.model.entites.Produto;
import br.com.curso.exerciciossb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

//    @PostMapping
//    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
//        produtoRepository.save(produto);
//        return produto;
//    }

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

//    @PutMapping
//    public Produto alterarProduto(@Valid Produto produto) {
//        produtoRepository.save(produto);
//        return produto;
//    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping("/pagina/{numeroPagina}/{tamDaPagina}")
    public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina, @PathVariable int tamDaPagina) {
        if(tamDaPagina >= 5) tamDaPagina = 5;
        Pageable page = PageRequest.of(numeroPagina, tamDaPagina);
        return produtoRepository.findAll(page);
    }

    @GetMapping("/nome/{parteNome}")
    public ArrayList<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
//        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
        return produtoRepository.searchByNameLike(parteNome);
    }
}
