package br.com.curso.exerciciossb.model.repositories;

import br.com.curso.exerciciossb.model.entites.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

//    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public ArrayList<Produto> searchByNameLike(@Param("nome") String parteNome);
}
