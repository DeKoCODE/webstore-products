package com.webstoreprodutos.repository;

import com.webstoreprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
