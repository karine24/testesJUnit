package br.com.curso.exerciciossb.model.repositories;

import br.com.curso.exerciciossb.model.entites.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void itShouldSearchByNameLike() {
        // given
        Produto produto = new Produto("Kindle", 400, 0.1);
        produtoRepository.save(produto);

        // when
        ArrayList<Produto> produtos = produtoRepository.searchByNameLike("Kindle");

        // then
        assertTrue(produtos.size() > 0, "Possui pelo menos um retorno");
//        assertThat(produtos)
    }

    @Test
    void itShouldNotFoundSearchByNameLike() {
        // given

        // when
        ArrayList<Produto> produtos = produtoRepository.searchByNameLike("Computador");

        // then
        assertEquals(0, produtos.size());
    }
}