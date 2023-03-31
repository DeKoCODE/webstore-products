package com.webstoreprodutos.controller;

import com.webstoreprodutos.model.Produto;
import com.webstoreprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProdutoController {
//    private final ProdutoRepository repository;
//    public ProdutoController (ProdutoRepository repository){
//        this.repository = repository;
//    }

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/")
    public String bemVindo(){
        return "Bem vindo, você está usando Spring Boot!";
    }

    @PostMapping("/produtos")
    public void postProduto(@RequestBody Produto produto){
        repository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> getProdutos(){
        return repository.findAll();
    }

   @DeleteMapping("/produtos/{id}")
    public void deleteProduto(@PathVariable("id") Long id){
        repository.deleteById(id);
   }
}
