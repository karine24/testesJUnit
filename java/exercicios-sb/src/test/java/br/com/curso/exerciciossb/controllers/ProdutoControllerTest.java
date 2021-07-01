package br.com.curso.exerciciossb.controllers;

import br.com.curso.exerciciossb.model.entites.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ProdutoControllerTest {

    @Test
    void salvarProduto() {
        ProdutoController produtoController = mock(ProdutoController.class);
        try {
            produtoController.salvarProduto(new Produto("Jogo", 29.91,2));
        } catch(Exception error) {
            throw error;
        }
    }
}